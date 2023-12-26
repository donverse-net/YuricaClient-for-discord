# Bot config
TOKEN="MTEwNTc4ODcxODQ1MjgzNDM4NA.GrqbHL.1HQpi5etV3fJsQJorwyucAGIQzfes8P5jJB6TQ"
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
