from PIL import Image
from pathlib import Path

# Directory containing your original 64×32 skins
skin_dir = Path("./")

# Directory to save the converted 64×64 skins
output_dir = Path("./")
output_dir.mkdir(exist_ok=True)

for skin_path in skin_dir.glob("*.png"):
    img = Image.open(skin_path)
    if img.size != (64, 32):
        # skip files that are already 64×64 or wrong size
        continue

    # Create a new 64×64 transparent canvas
    new = Image.new("RGBA", (64, 64), (0, 0, 0, 0))
    # Paste the original 64×32 skin at the top
    new.paste(img, (0, 0))

    # === Right‐leg overlays (as before) ===
    leg_front  = img.crop((4, 20,  8, 32))
    leg_back   = img.crop((12,20, 16, 32))
    leg_left   = img.crop((0, 20,  4, 32))
    leg_right  = img.crop((8, 20, 12, 32))
    leg_top    = img.crop((4, 16,  8, 20))
    leg_bottom = img.crop((8, 16, 12, 20))

    # Paste right‐leg overlay faces
    new.paste(leg_top,    (4, 32), mask=leg_top)
    new.paste(leg_bottom, (8, 32), mask=leg_bottom)
    new.paste(leg_left,   (0, 36), mask=leg_left)
    new.paste(leg_front,  (4, 36), mask=leg_front)
    new.paste(leg_right,  (12,36), mask=leg_right)
    new.paste(leg_back,   (8, 36), mask=leg_back)

    # === Right‐arm overlays (new!) ===
    arm_front  = img.crop((44, 20, 48, 32))
    arm_back   = img.crop((52, 20, 56, 32))
    arm_left   = img.crop((40, 20, 44, 32))
    arm_right  = img.crop((48, 20, 52, 32))
    arm_top    = img.crop((44, 16, 48, 20))
    arm_bottom = img.crop((48, 16, 52, 20))

    # Paste right‐arm overlay faces
    new.paste(arm_top,    (44, 32), mask=arm_top)
    new.paste(arm_bottom, (48, 32), mask=arm_bottom)
    new.paste(arm_left,   (40, 36), mask=arm_left)
    new.paste(arm_front,  (44, 36), mask=arm_front)
    new.paste(arm_right,  (52, 36), mask=arm_right)
    new.paste(arm_back,   (48, 36), mask=arm_back)

    # === Mirror overlays for left leg & left arm ===
    def mirror_and_paste(region, dest):
        flipped = region.transpose(Image.FLIP_LEFT_RIGHT)
        new.paste(flipped, dest, mask=flipped)

    # Left‐leg overlays
    mirror_and_paste(leg_top,    (20,48))
    mirror_and_paste(leg_bottom, (24,48))
    mirror_and_paste(leg_left,   (16,52))
    mirror_and_paste(leg_front,  (20,52))
    mirror_and_paste(leg_right,  (28,52))
    mirror_and_paste(leg_back,   (24,52))

    # Left‐arm overlays
    mirror_and_paste(arm_top,    (36,48))
    mirror_and_paste(arm_bottom, (40,48))
    mirror_and_paste(arm_left,   (32,52))
    mirror_and_paste(arm_front,  (36,52))
    mirror_and_paste(arm_right,  (44,52))
    mirror_and_paste(arm_back,   (40,52))

    # Save the converted skin
    new.save(output_dir / skin_path.name)

print("Conversion complete! New skins are in:", output_dir)

