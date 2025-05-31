#!/bin/bash

# Backend and Frontend
npx concurrently --names "BACKEND,FRONTEND" "cd backend && ./dev.sh" "cd frontend && ./dev.sh"
