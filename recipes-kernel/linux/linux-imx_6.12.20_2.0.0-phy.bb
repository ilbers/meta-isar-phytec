# Copyright (C) 2019 PHYTEC Messtechnik GmbH,
# Author: Teresa Remmet <t.remmet@phytec.de>
# Adopted to Isar: Anton Mikanovich <amikan@ilbers.de>

inherit phygittag
inherit buildinfo
inherit fsl-vivante-kernel-driver-handler
include linux-common.inc

BRANCH = "v6.12.20-2.0.0-phy"
GIT_URL = "git://github.com/phytec/linux-phytec-imx.git"
SRC_URI += "${GIT_URL};branch=${BRANCH}"
PR = "${INC_PR}.0"

# Fix for make dtbs_install issue
SRC_URI += "file://0002-v2-dtbsinstall-fix-installing-DT-overlays.patch"

# Disable LVDS 1 on pollux board for HDMI to work
SRC_URI += "file://0003-v2-Disable-LVDS-1-on-pollux.patch"

# Fix extension board dtb can not be applied problem
SRC_URI += "file://0004-Disable-extension-board-output.patch"

LINUX_VERSION_EXTENSION = "-isar"

# NOTE: PV must be in the format "x.y.z-.*". It cannot begin with a 'v'.
# NOTE: Keep version in filename in sync with commit id!
SRCREV = "3747105028160a43feb00d97dd423c14804d48a0"

S = "${WORKDIR}/git"

KERNEL_DEFCONFIG = "imx_v8_defconfig"

COMPATIBLE_MACHINE  = "^("
COMPATIBLE_MACHINE .= "phyboard-polaris-imx8m-3"
COMPATIBLE_MACHINE .= "|phyboard-polis-imx8mm-4"
COMPATIBLE_MACHINE .= "|phyboard-pollux-imx8mp-3"
COMPATIBLE_MACHINE .= "|phygate-tauri-imx8mm-1"
COMPATIBLE_MACHINE .= "|phygate-tauri-imx8mm-2"
COMPATIBLE_MACHINE .= ")$"
