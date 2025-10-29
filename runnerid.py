print("Park Run Timer\n")
print("~~~~~~~~~~~~~~\n")
print("Let's go!")

time_sum = 0
counter = 0
fastest_time = None
slowest_time = None
fastest = ""
slowest = ""

while True:
    data_stream = input("Enter runner's number with time (e.g. 101::320): ")

    if data_stream == "END":
        break

    if not data_stream.strip():
        print("No data entered. Please try again.")
        continue

    runnerid_time = data_stream.split("::")

    if len(runnerid_time) != 2:
        print("Invalid format. Please use RunnerID::Time.")
        continue

    player_number, player_time = runnerid_time[0].strip(), runnerid_time[1].strip()

    if not player_number or not player_time.isdigit():
        print("Error in data stream. Ignoring. Carry on.")
        continue

    player_time = int(player_time)

    if counter == 0:
        fastest_time = player_time
        slowest_time = player_time
        fastest = data_stream
        slowest = data_stream

    if player_time < fastest_time:
        fastest_time = player_time
        fastest = data_stream

    if player_time > slowest_time:
        slowest_time = player_time
        slowest = data_stream

    counter += 1
    time_sum += player_time

# Handle case where no valid runners were entered
if counter == 0:
    print("\nNo data found, nothing to do. What a shame!")
else:
    average_time = time_sum / counter

    # Convert to minutes and seconds
    def convert_time(seconds):
        return seconds // 60, seconds % 60

    fastest_time_minutes, fastest_time_seconds = convert_time(fastest_time)
    slowest_time_minutes, slowest_time_seconds = convert_time(slowest_time)
    average_time_minutes, average_time_seconds = convert_time(int(average_time))

    total_runners = counter
    fastest_id = fastest.split("::")[0]

    # Results
    print("\nResults Summary")
    print("----------------")
    print("Total runners: {}".format(total_runners))
    print("Average time: {} minute(s), {} second(s)".format(average_time_minutes, average_time_seconds))
    print("Fastest time: {} minute(s), {} second(s)".format(fastest_time_minutes, fastest_time_seconds))
    print("Slowest time: {} minute(s), {} second(s)".format(slowest_time_minutes, slowest_time_seconds))
    print("\nBest time here: Runner #{}".format(fastest_id))
