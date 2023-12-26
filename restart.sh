# Shell script place
START="./start.sh"
STOP="./stop.sh"

# Stop
echo "Stopping..."
bash $STOP

# wait 2 sec
sleep 2

# Start
echo "Starting..."
bash $START

# Complete
echo "Restart is completed!"
