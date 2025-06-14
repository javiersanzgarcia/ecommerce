#!/bin/sh

# Get all tracked files that are being committed
git diff --cached --name-only | while read file; do
  # Only process text files
  if file "$file" | grep -q "text"; then
    # Check if the file ends with a newline
    if [ "$(tail -c 1 "$file")" != "" ]; then
      # Add newline if missing
      echo "" >> "$file"
      # Add the modified file back to staging
      git add "$file"
    fi
  fi
done
