#!/bin/bash

INPUT="$1"
OUTPUT="${INPUT%.java}.json"

# Extract values using grep and sed
box_line=$(grep 'addBox' "$INPUT")
rotation_line=$(grep 'setRotationPoint' "$INPUT")

# Parse coordinates and dimensions
read -r x y z dx dy dz <<<$(echo "$box_line" | sed -E 's/.*addBox\((-?[0-9.]+)f?, (-?[0-9.]+)f?, (-?[0-9.]+)f?, ([0-9]+), ([0-9]+), ([0-9]+)\).*/\1 \2 \3 \4 \5 \6/')

# Parse rotation point
read -r rx ry rz <<<$(echo "$rotation_line" | sed -E 's/.*setRotationPoint\((-?[0-9.]+)f?, (-?[0-9.]+)f?, (-?[0-9.]+)f?\).*/\1 \2 \3/')

# Convert positions to positive coordinates (origin at [0,0,0])
from_x=$(echo "$x + $rx" | bc)
from_y=$(echo "$y + $ry" | bc)
from_z=$(echo "$z + $rz" | bc)
to_x=$(echo "$from_x + $dx" | bc)
to_y=$(echo "$from_y + $dy" | bc)
to_z=$(echo "$from_z + $dz" | bc)

# Output JSON
cat > "$OUTPUT" <<EOF
{
  "parent": "item/generated",
  "textures": {
    "layer0": "freespawn:item/coin"
  },
  "elements": [
    {
      "from": [ $from_x, $from_y, $from_z ],
      "to": [ $to_x, $to_y, $to_z ],
      "faces": {
        "north": { "uv": [ 0, 0, 16, 16 ], "texture": "#layer0" },
        "south": { "uv": [ 0, 0, 16, 16 ], "texture": "#layer0" }
      }
    }
  ]
}
EOF

echo "Generated: $OUTPUT"
