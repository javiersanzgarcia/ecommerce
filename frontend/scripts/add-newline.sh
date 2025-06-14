#!/bin/bash

# Find all relevant files
find src -type f \( -name "*.js" -o -name "*.jsx" -o -name "*.ts" -o -name "*.tsx" -o -name "*.json" -o -name "*.css" -o -name "*.scss" -o -name "*.md" \) | while read file; do
    # Get the last character
    last_char=$(tail -c 1 "$file")
    
    # If the file is empty or doesn't end with newline, add one
    if [ -z "$last_char" ] || [ "$last_char" != $'\n' ]; then
        echo "Adding newline to $file"
        # Add newline
        echo "" >> "$file"
        # Add the file to git staging
        git add "$file"
    fi
done
