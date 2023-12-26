# Bot config
TOKEN=""
SHARD_ID=8
SHARD_TOTAL=10

# Bot start
#  ---------------------------------------------------------------- screen command
#  |     ---------------------------------------------------------- -dm: start detached screen -S: screen name
#  |     |     ---------------------------------------------------- Screen name
#  |     |     |
#  |     |     |         ------------------------------------------ java command
#  |     |     |         |         -------------------------------- jar file
#  |     |     |         |         |          --------------------- bot token
#  |     |     |         |         |          |       ------------- shard id
#  |     |     |         |         |          |       |         --- shard total
#  |     |     |         |         |          |       |         |
screen -dmS yurica_app java -jar yurica.jar $TOKEN $SHARD_ID $SHARD_TOTAL
