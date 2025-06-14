#!/bin/bash

# Function to check if file ends with newline
check_newline() {
    local file=$1
    local last_char=$(tail -c 1 "$file")
    
    echo "Checking $file:"
    echo "Last character: '$last_char'"
    echo "File ends with newline: $(if [ "$last_char" = $'\n' ]; then echo "YES"; else echo "NO"; fi)"
    
    # Show the last few bytes in hex
    echo "Last bytes (hex):"
    tail -c 10 "$file" | xxd
}

# Check specific files
check_newline "src/test.js"
check_newline "src/hooks/useFetch.ts"
