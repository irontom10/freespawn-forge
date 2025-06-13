#!/bin/bash

set -e

# --- Texture URLs ---
OLD_STONE_URL="https://raw.githubusercontent.com/InventivetalentDev/minecraft-assets/1.7.10/assets/minecraft/textures/blocks/stone.png"
NEW_STONE_URL="https://raw.githubusercontent.com/InventivetalentDev/minecraft-assets/1.20.1/assets/minecraft/textures/block/stone.png"
DEEPSLATE_URL="https://raw.githubusercontent.com/InventivetalentDev/minecraft-assets/1.20.1/assets/minecraft/textures/block/deepslate.png"

# --- Download Required Textures Once ---
mkdir -p base_textures
cd base_textures
wget -q -nc -O old_stone.png "$OLD_STONE_URL"
wget -q -nc -O new_stone.png "$NEW_STONE_URL"
wget -q -nc -O deepslate.png "$DEEPSLATE_URL"
cd ..

# --- Process Each Argument ---
for INPUT_TEXTURE in "$@"; do
    if [[ ! -f "$INPUT_TEXTURE" ]]; then
        echo "❌ Skipping: $INPUT_TEXTURE is not a file."
        continue
    fi

    BASENAME=$(basename "$INPUT_TEXTURE" .png)
    OUTDIR="output_$BASENAME"
    mkdir -p "$OUTDIR"

    echo "▶ Processing $INPUT_TEXTURE → $OUTDIR"

    cp "$INPUT_TEXTURE" "$OUTDIR/ore_input.png"
    cp base_textures/*.png "$OUTDIR/"

    pushd "$OUTDIR" > /dev/null

    # Step 1: Create Ore Mask
    composite -compose Difference ore_input.png old_stone.png mask_diff.png

    # Step 2: Threshold
    convert mask_diff.png -threshold 10% mask_alpha.png

    # Step 3: Apply Mask
    convert ore_input.png mask_alpha.png -alpha off -compose CopyOpacity -composite ore_cutout.png

    # Step 4: Overlay
    composite -compose Over ore_cutout.png new_stone.png "stone_${BASENAME}.png"
    composite -compose Over ore_cutout.png deepslate.png "deepslate_${BASENAME}.png"

    echo "✅ Done: stone_${BASENAME}.png, deepslate_${BASENAME}.png"
    popd > /dev/null
done
