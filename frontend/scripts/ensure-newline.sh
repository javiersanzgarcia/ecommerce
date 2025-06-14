#!/bin/bash

# Get all tracked files that are being committed
git diff --cached --name-only | while read file; do
  # Only process text files
  if [[ "$file" =~ \.\(js\|jsx\|ts\|tsx\|json\|css\|scss\|md\)$ ]]; then
    # Check if the file ends with a newline
    if [ "$(tail -c 1 "$file")" != "" ]; then
      # Add newline if missing
      echo "" >> "$file"
      # Add the modified file back to staging
      git add "$file"
    fi
  fi
done

# Run Prettier
prettier --write "**/*.{js,jsx,ts,tsx,json,css,scss,md}"
