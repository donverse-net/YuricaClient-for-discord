# Config
SCREEN_NAME="yurica_app"

# Stop
screen -S $SCREEN_NAME -X stuff "stop\n"
# wait 2 sec
sleep 2
# Kill screen
# screen -X -S $SCREEN_NAME quit
