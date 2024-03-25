print("Park Run Timer\n")
print("~~~~~~~~~~~~~~\n")
print("let's go!")

time_sum=0
counter=0
while(True):
  data_stream=input("enter runners number with time:")
  if (data_stream =="END"):
     break
  runnerid_time=data_stream.split("::")
    
  if (data_stream==""):
      print("END")
      print("no data found,nothing to do, what a shame")
  
  
  if (len(runnerid_time)>2):
      print("invalid format")
      break
            
  if (runnerid_time[0]=="" or runnerid_time[1] ==""):
    print("Error in data stream. Ignorning. Carry on.")
    
  else:
    player_time=runnerid_time[1]
    player_number=runnerid_time[0]
        
    if(counter==0):
        fastest=data_stream
        fastest_time=int(runnerid_time[1])
        slowest_time=int(runnerid_time[1]) 

        
    if(fastest_time>int(runnerid_time[1])):
      fastest_time=int(runnerid_time[1])
      fastest=data_stream
            
    if(slowest_time<int(runnerid_time[1])):
       slowest_time=int(runnerid_time[1])
       slowest=data_stream

    counter+=1
    
    time_sum+=int(runnerid_time[0])    
    average_time=time_sum/counter

fastest_time_minutes=fastest_time//60
fastest_time_seconds=(fastest_time)-(fastest_time_minutes*60)

slowest_time_minutes=slowest_time//60
slowest_time_seconds=(slowest_time)-(slowest_time_minutes*60)

average_time_minutes=int(average_time//60)
average_time_seconds=int(average_time)-int(average_time_minutes*60)

total_runners=counter

fastest_id=fastest.split("::")
fastest_id=fastest[:2]

print("\n")
print("total_runners:{}".format(total_runners))
print("average_time:{} minute, {} seconds".format(average_time_minutes,average_time_seconds))
print("fastest_time:{} minute,{} seconds".format(fastest_time_minutes,fastest_time_seconds))
print("slowest_time:{} minute,{} seconds".format(slowest_time_minutes,slowest_time_seconds))
print("\n")
print("best_time_here:Runner #{}".format(fastest_id))
