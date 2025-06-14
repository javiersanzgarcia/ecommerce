#!/bin/bash

# Find all relevant files and ensure they end with a newline
find src -type f \( -name "*.js" -o -name "*.jsx" -o -name "*.ts" -o -name "*.tsx" -o -name "*.json" -o -name "*.css" -o -name "*.scss" -o -name "*.md" \) -exec bash -c '
    if [ "$(tail -c 1 "{}")" != "" ]; then
        echo "Adding newline to {}"
        echo "" >> "{}"
    fi
' \;

# Run Prettier
prettier --write "**/*.{js,jsx,ts,tsx,json,css,scss,md}"
