{
	"monitorItems":
		[{"opts":[""],"oldId":null,"gmtCreate":1291041445000,"status":null,"targetId":13491,"scheduleExpression":"[* * * * * ?]","alarmRules":[{"criticalExpression":"@MemoryHeapUsed>5000000000000000L","warningExpressionDescription":"1","monitorItemId":134985,"alarmInterval":60,"alarmReceivers":[{"id":186982,"isUpgrade":"n","userId":609247,"receiveRuleId":839375,"alarmRuleId":186981}],"upgradeInterval":60,"id":186981,"content":" lllll00000111111","priority":"n","name":"yyyy","warningExpression":"@MemoryHeapUsed>1000000000000000L","criticalExpressionDescription":"1","alarmCount":5,"notifyOk":"y"},{"criticalExpression":"@MemoryHeapUsed>500000000000000L","warningExpressionDescription":"","monitorItemId":134985,"alarmInterval":300,"alarmReceivers":[{"id":186984,"isUpgrade":"n","userId":609247,"receiveRuleId":839375,"alarmRuleId":186983}],"upgradeInterval":60,"id":186983,"content":"qq","priority":"n","name":"qq3qq","warningExpression":"@MemoryHeapUsed>100000000000000L","criticalExpressionDescription":"","alarmCount":3,"notifyOk":"y"}],"endTime":1293258958000,"type":"a","monitorItemTypeId":2,"startTime":1291098956000,"id":134985,"collectUrl":"jmx:\/\/GetAttr\/com.amyliascarlet.dragoon:type=Memory(\"MemoryHeapCommitted\", \"MemoryHeapUsed\", \"MemoryNonHeapCommitted\", \"MemoryNonHeapUsed\", \"UsedPhysicalMemorySize\", \"TotalPhysicalMemorySize\", \"UsedSwapSpaceSize\", \"TotalSwapSpaceSize\")","scheduleTimeout":5,"description":"desc","name":"jvm_memory","scheduleIntervalAlarm":30,"locked":"n","targetType":"a","scheduleInterval":60},{"opts":[],"oldId":null,"gmtCreate":1289484086000,"status":null,"targetId":23911,"scheduleExpression":"[* * * * * ?]","alarmRules":[],"type":"a","monitorItemTypeId":1,"id":26945,"collectUrl":"jmx:\/\/GetAttr\/com.amyliascarlet.dragoon:type=Threading(\"DaemonThreadCount\", \"ThreadCount\", \"NewThreadCount\", \"RunnableThreadCount\", \"BlockedThreadCount\", \"WaitingThreadCount\", \"TimedWaitingThreadCount\", \"TeminatedThreadCount\", \"DeadLockedThreadCount\", \"TotalStartedThreadCount\", \"ProcessCpuTimeRate\", \"FullGCCollectionTimeRate\")","scheduleTimeout":5,"description":"jvm_threading","name":"jvm_threading","scheduleIntervalAlarm":60,"locked":"n","targetType":"a","scheduleInterval":300},{"opts":["reset=true"],"oldId":null,"gmtCreate":1293043940000,"status":null,"targetId":3,"scheduleExpression":"[* * * * * ?]","alarmRules":[{"criticalExpression":"@Count>20","warningExpressionDescription":"This is early warning","monitorItemId":2,"alarmInterval":5,"alarmReceivers":[{"id":1,"isUpgrade":"n","userId":101,"receiveRuleId":null,"alarmRuleId":1},{"id":2,"isUpgrade":"y","userId":102,"receiveRuleId":null,"alarmRuleId":1}],"upgradeInterval":60,"id":1,"content":"This is the alram message","priority":"n","name":"TestRule015","warningExpression":"@Count>10","criticalExpressionDescription":"This is warning","alarmCount":2,"notifyOk":"y"}],"endTime":1293130340000,"type":"a","monitorItemTypeId":5,"startTime":1292957540000,"id":2,"collectUrl":"jmx:\/\/GetAttr\/com.amyliascarlet.dragoon:type=Exception(\"ErrorList\")","scheduleTimeout":5,"description":"exception","name":"exception","scheduleIntervalAlarm":60,"locked":"y","targetType":"a","scheduleInterval":300},{"opts":[],"oldId":null,"gmtCreate":1290004798000,"status":null,"targetId":23910,"scheduleExpression":"[* * * * * ?]","alarmRules":[],"endTime":1293679862000,"type":"a","monitorItemTypeId":1,"startTime":1291347060000,"id":609351,"collectUrl":"jmx:\/\/GetAttr\/com.amyliascarlet.dragoon:type=Threading(\"DaemonThreadCount\", \"ThreadCount\", \"NewThreadCount\", \"RunnableThreadCount\", \"BlockedThreadCount\", \"WaitingThreadCount\", \"TimedWaitingThreadCount\", \"TeminatedThreadCount\", \"DeadLockedThreadCount\", \"TotalStartedThreadCount\", \"ProcessCpuTimeRate\", \"FullGCCollectionTimeRate\")","scheduleTimeout":5,"description":"jvm_threading","name":"jvm_threading","scheduleIntervalAlarm":60,"locked":"n","targetType":"a","scheduleInterval":300},{"opts":[],"oldId":null,"gmtCreate":1289246125000,"status":null,"targetId":691,"scheduleExpression":"[* * * * * ?]","alarmRules":[{"criticalExpression":"@ProcessCpuTimeRate>=0","warningExpressionDescription":"","monitorItemId":6923,"alarmInterval":60,"alarmReceivers":[{"id":1549131,"isUpgrade":"n","userId":1,"receiveRuleId":null,"alarmRuleId":1549130}],"upgradeInterval":300,"id":1549130,"content":"cr=waring","priority":"n","name":"dragoon","warningExpression":"@ProcessCpuTimeRate>=0","criticalExpressionDescription":"","alarmCount":3,"notifyOk":"y"}],"endTime":1320152730000,"type":"a","monitorItemTypeId":1,"startTime":1288612476000,"id":6923,"collectUrl":"jmx:\/\/GetAttr\/com.amyliascarlet.dragoon:type=Threading(\"DaemonThreadCount\", \"ThreadCount\", \"NewThreadCount\", \"RunnableThreadCount\", \"BlockedThreadCount\", \"WaitingThreadCount\", \"TimedWaitingThreadCount\", \"TeminatedThreadCount\", \"DeadLockedThreadCount\", \"TotalStartedThreadCount\", \"ProcessCpuTimeRate\", \"FullGCCollectionTimeRate\")","scheduleTimeout":5,"description":"jvm_threading","name":"jvm_threading","scheduleIntervalAlarm":60,"locked":"y","targetType":"a","scheduleInterval":60},
		 
		 {"opts":["reset=true"],"oldId":null,
			"gmtCreate":1293043660000,"status":null,"targetId":3,"scheduleExpression":"[* * * * * ?]","alarmRules":[],
			"endTime":1293130060000,"type":"a","monitorItemTypeId":1,"startTime":1292957260000,"id":14,"collectUrl":"jmx:\/\/GetAttr\/com.amyliascarlet.dragoon:type=Threading(\"DaemonThreadCount\", \"ThreadCount\", \"NewThreadCount\", \"RunnableThreadCount\", \"BlockedThreadCount\", \"WaitingThreadCount\", \"TimedWaitingThreadCount\", \"TeminatedThreadCount\", \"DeadLockedThreadCount\", \"TotalStartedThreadCount\", \"ProcessCpuTimeRate\", \"FullGCCollectionTimeRate\")","scheduleTimeout":5,"description":"jvm_memory","name":"jvm_memory","scheduleIntervalAlarm":60,"locked":"y","targetType":"a","scheduleInterval":300},{"opts":[],"oldId":null,"gmtCreate":1289484086000,"status":null,"targetId":23911,"scheduleExpression":"[* * * * * ?]","alarmRules":[{"criticalExpression":"@MemoryHeapUsed>100000000000000L","warningExpressionDescription":"111","monitorItemId":26961,"alarmInterval":80,"alarmReceivers":[{"id":1349244,"isUpgrade":"n","userId":609247,"receiveRuleId":839375,"alarmRuleId":1349243}],"upgradeInterval":100,"id":1349243,"content":"������","priority":"n","name":"MEM","warningExpression":"@MemoryHeapUsed>0","criticalExpressionDescription":"111","alarmCount":3,"notifyOk":"y"}],"endTime":1291087377000,"type":"a","monitorItemTypeId":2,"startTime":1290396174000,"id":26961,"collectUrl":"jmx:\/\/GetAttr\/com.amyliascarlet.dragoon:type=Memory(\"MemoryHeapCommitted\", \"MemoryHeapUsed\", \"MemoryNonHeapCommitted\", \"MemoryNonHeapUsed\", \"UsedPhysicalMemorySize\", \"TotalPhysicalMemorySize\", \"UsedSwapSpaceSize\", \"TotalSwapSpaceSize\")","scheduleTimeout":5,"description":"desc1","name":"jvm_memory","scheduleIntervalAlarm":60,"locked":"n","targetType":"a","scheduleInterval":60},{"opts":[""],"oldId":null,"gmtCreate":1291547021000,"status":null,"targetId":23911,"scheduleExpression":"[* * * * * ?]","alarmRules":[],"type":"a","monitorItemTypeId":4,"id":166945,"collectUrl":"jmx:\/\/GetAttr\/com.amyliascarlet.dragoon:type=JVM(\"PID\", \"StartTime\", \"InputArguments\", \"Arch\", \"OSName\", \"OSVersion\", \"JVM\", \"JavaVersion\", \"JavaHome\", \"JavaLibraryPath\", \"JavaSpecificationVersion\", \"AvailableProcessors\", \"LoadedClassCount\", \"TotalLoadedClassCount\", \"UnloadedClassCount\", \"TotalCompilationTime\")","scheduleTimeout":5,"description":"jvm_info","name":"jvm_info","scheduleIntervalAlarm":30,"locked":"n","targetType":"a","scheduleInterval":300},{"opts":[],"oldId":null,"gmtCreate":1290004798000,"status":null,"targetId":23910,"scheduleExpression":"[* * * * * ?]","alarmRules":[],"type":"a","monitorItemTypeId":2,"id":609367,"collectUrl":"jmx:\/\/GetAttr\/com.amyliascarlet.dragoon:type=Memory(\"MemoryHeapCommitted\", \"MemoryHeapUsed\", \"MemoryNonHeapCommitted\", \"MemoryNonHeapUsed\", \"UsedPhysicalMemorySize\", \"TotalPhysicalMemorySize\", \"UsedSwapSpaceSize\", \"TotalSwapSpaceSize\")","scheduleTimeout":5,"description":"desc1","name":"jvm_memory","scheduleIntervalAlarm":60,"locked":"n","targetType":"a","scheduleInterval":300},{"opts":[],"oldId":null,"gmtCreate":1289484086000,"status":null,"targetId":23911,"scheduleExpression":"[* * * * * ?]","alarmRules":[],"endTime":1291086872000,"type":"a","monitorItemTypeId":3,"startTime":1290395668000,"id":26969,"collectUrl":"jmx:\/\/GetAttr\/com.amyliascarlet.dragoon:type=GC(\"PermGenUsed\", \"OldGenUsed\", \"EdenSpaceUsed\", \"SurvivorSpaceUsed\", \"FullGCCollectionCount\", \"FullGCCollectionTime\", \"YoungGCCollectionCount\", \"YoungGCCollectionTime\")","scheduleTimeout":5,"description":"jvm_gc","name":"jvm_gc","scheduleIntervalAlarm":60,"locked":"n","targetType":"a","scheduleInterval":300},{"opts":["reset=true"],"oldId":null,"gmtCreate":1291039361000,"status":null,"targetId":13491,"scheduleExpression":"[* * * * * ?]","alarmRules":[{"criticalExpression":"@Count>8","warningExpressionDescription":"","monitorItemId":13498,"alarmInterval":60,"alarmReceivers":[{"id":1869176,"isUpgrade":"n","userId":609247,"receiveRuleId":839375,"alarmRuleId":1869175}],"upgradeInterval":60,"id":1869175,"content":"count-----","priority":"n","name":"Count","warningExpression":"@Count>3","criticalExpressionDescription":"","alarmCount":5,"notifyOk":"y"}],"type":"a","monitorItemTypeId":5,"id":13498,"collectUrl":"jmx:\/\/GetAttr\/com.amyliascarlet.dragoon:type=Exception(\"ErrorList\")","scheduleTimeout":5,"description":"exception helloooo","name":"exception","scheduleIntervalAlarm":15,"locked":"n","targetType":"a","scheduleInterval":60},{"opts":[],"oldId":null,"gmtCreate":1289246125000,"status":null,"targetId":691,"scheduleExpression":"[* * * * * ?]","alarmRules":[],"endTime":1320152730000,"type":"a","monitorItemTypeId":2,"startTime":1285934088000,"id":6939,"collectUrl":"jmx:\/\/GetAttr\/com.amyliascarlet.dragoon:type=Memory(\"MemoryHeapCommitted\", \"MemoryHeapUsed\", \"MemoryNonHeapCommitted\", \"MemoryNonHeapUsed\", \"UsedPhysicalMemorySize\", \"TotalPhysicalMemorySize\", \"UsedSwapSpaceSize\", \"TotalSwapSpaceSize\")","scheduleTimeout":5,"description":"desc1","name":"jvm_memory","scheduleIntervalAlarm":60,"locked":"y","targetType":"a","scheduleInterval":300},{"opts":[],"oldId":null,"gmtCreate":1290004798000,"status":null,"targetId":23910,"scheduleExpression":"[* * * * * ?]","alarmRules":[],"type":"a","monitorItemTypeId":3,"id":609375,"collectUrl":"jmx:\/\/GetAttr\/com.amyliascarlet.dragoon:type=GC(\"PermGenUsed\", \"OldGenUsed\", \"EdenSpaceUsed\", \"SurvivorSpaceUsed\", \"FullGCCollectionCount\", \"FullGCCollectionTime\", \"YoungGCCollectionCount\", \"YoungGCCollectionTime\")","scheduleTimeout":5,"description":"jvm_gc","name":"jvm_gc","scheduleIntervalAlarm":60,"locked":"n","targetType":"a","scheduleInterval":300},{"opts":[],"oldId":null,"gmtCreate":1289420051000,"status":null,"targetId":1920,"scheduleExpression":"[* * * * * ?]","alarmRules":[],"endTime":1289477648000,"type":"a","monitorItemTypeId":3,"startTime":1289477648000,"id":1894,"collectUrl":"jmx:\/\/GetAttr\/com.amyliascarlet.dragoon:type=GC(\"PermGenUsed\", \"OldGenUsed\", \"EdenSpaceUsed\", \"SurvivorSpaceUsed\", \"FullGCCollectionCount\", \"FullGCCollectionTime\", \"YoungGCCollectionCount\", \"YoungGCCollectionTime\")","scheduleTimeout":5,"description":"<hr>","name":"<hr>","scheduleIntervalAlarm":60,"locked":"n","targetType":"a","scheduleInterval":300},{"opts":[""],"oldId":null,"gmtCreate":1291041532000,"status":null,"targetId":13491,"scheduleExpression":"[* * * * * ?]","alarmRules":[{"criticalExpression":"@FullGCCollectionCount>0","warningExpressionDescription":"","monitorItemId":134998,"alarmInterval":90,"alarmReceivers":[{"id":188918,"isUpgrade":"y","userId":609247,"receiveRuleId":839375,"alarmRuleId":188917},{"id":188919,"isUpgrade":"n","userId":609247,"receiveRuleId":839375,"alarmRuleId":188917}],"upgradeInterval":60,"id":188917,"content":"uuu","priority":"n","name":"uuu","warningExpression":"@FullGCCollectionCount>0","criticalExpressionDescription":"","alarmCount":5,"notifyOk":"y"},{"criticalExpression":"@FullGCCollectionCount>0","warningExpressionDescription":"","monitorItemId":134998,"alarmInterval":60,"alarmReceivers":[{"id":188921,"isUpgrade":"n","userId":609247,"receiveRuleId":null,"alarmRuleId":188920}],"upgradeInterval":60,"id":188920,"content":"1111","priority":"n","name":"www","warningExpression":"@FullGCCollectionCount>0","criticalExpressionDescription":"","alarmCount":5,"notifyOk":"y"}],"endTime":1291876672000,"type":"a","monitorItemTypeId":3,"startTime":1291099070000,"id":134998,"collectUrl":"jmx:\/\/GetAttr\/com.amyliascarlet.dragoon:type=GC(\"PermGenUsed\", \"OldGenUsed\", \"EdenSpaceUsed\", \"SurvivorSpaceUsed\", \"FullGCCollectionCount\", \"FullGCCollectionTime\", \"YoungGCCollectionCount\", \"YoungGCCollectionTime\")","scheduleTimeout":5,"description":"jvm_gc","name":"jvm_gc","scheduleIntervalAlarm":59,"locked":"n","targetType":"a","scheduleInterval":60},{"opts":["reset=true"],"oldId":null,"gmtCreate":1289484086000,"status":null,"targetId":23911,"scheduleExpression":"[* * * * * ?]","alarmRules":[{"criticalExpression":"@Count>20","warningExpressionDescription":"11","monitorItemId":26983,"alarmInterval":80,"alarmReceivers":[{"id":1719290,"isUpgrade":"n","userId":1,"receiveRuleId":null,"alarmRuleId":1719289},{"id":1719291,"isUpgrade":"n","userId":609247,"receiveRuleId":null,"alarmRuleId":1719289}],"upgradeInterval":60,"id":1719289,"content":"123","priority":"n","name":"exp","warningExpression":"@Count>10","criticalExpressionDescription":"22","alarmCount":2,"notifyOk":"y"}],"endTime":1291102935000,"type":"a","monitorItemTypeId":5,"startTime":1291016533000,"id":26983,"collectUrl":"jmx:\/\/GetAttr\/com.amyliascarlet.dragoon:type=Exception(\"ErrorList\")","scheduleTimeout":5,"description":"exception","name":"exception","scheduleIntervalAlarm":50,"locked":"n","targetType":"a","scheduleInterval":60},{"opts":[],"oldId":null,"gmtCreate":1289246125000,"status":null,"targetId":691,"scheduleExpression":"[* * * * * ?]","alarmRules":[],"endTime":1320152730000,"type":"a","monitorItemTypeId":3,"startTime":1288612404000,"id":6947,"collectUrl":"jmx:\/\/GetAttr\/com.amyliascarlet.dragoon:type=GC(\"PermGenUsed\", \"OldGenUsed\", \"EdenSpaceUsed\", \"SurvivorSpaceUsed\", \"FullGCCollectionCount\", \"FullGCCollectionTime\", \"YoungGCCollectionCount\", \"YoungGCCollectionTime\")","scheduleTimeout":5,"description":"jvm_gc","name":"jvm_gc","scheduleIntervalAlarm":60,"locked":"n","targetType":"a","scheduleInterval":300},{"opts":[],"oldId":null,"gmtCreate":1289905202000,"status":null,"targetId":1920,"scheduleExpression":"[* * * * * ?]","alarmRules":[],"type":"a","monitorItemTypeId":1,"id":60955,"collectUrl":"jmx:\/\/GetAttr\/com.amyliascarlet.dragoon:type=Threading(\"DaemonThreadCount\", \"ThreadCount\", \"NewThreadCount\", \"RunnableThreadCount\", \"BlockedThreadCount\", \"WaitingThreadCount\", \"TimedWaitingThreadCount\", \"TeminatedThreadCount\", \"DeadLockedThreadCount\", \"TotalStartedThreadCount\", \"ProcessCpuTimeRate\", \"FullGCCollectionTimeRate\")","scheduleTimeout":5,"description":"jvm_threading","name":"jvm_threading","scheduleIntervalAlarm":60,"locked":"n","targetType":"a","scheduleInterval":300},{"opts":[],"oldId":null,"gmtCreate":1290004798000,"status":null,"targetId":23910,"scheduleExpression":"[* * * * * ?]","alarmRules":[],"type":"a","monitorItemTypeId":4,"id":609387,"collectUrl":"jmx:\/\/GetAttr\/com.amyliascarlet.dragoon:type=JVM(\"PID\", \"StartTime\", \"InputArguments\", \"Arch\", \"OSName\", \"OSVersion\", \"JVM\", \"JavaVersion\", \"JavaHome\", \"JavaLibraryPath\", \"JavaSpecificationVersion\", \"AvailableProcessors\", \"LoadedClassCount\", \"TotalLoadedClassCount\", \"UnloadedClassCount\", \"TotalCompilationTime\")","scheduleTimeout":5,"description":"jvm_info","name":"jvm_info","scheduleIntervalAlarm":60,"locked":"n","targetType":"a","scheduleInterval":300},{"opts":["reset=true"],"oldId":null,"gmtCreate":1289246125000,"status":null,"targetId":691,"scheduleExpression":"[* * * * * ?]","alarmRules":[{"criticalExpression":"1","warningExpressionDescription":"","monitorItemId":6956,"alarmInterval":60,"alarmReceivers":[{"id":166911,"isUpgrade":"n","userId":1,"receiveRuleId":null,"alarmRuleId":166910}],"upgradeInterval":60,"id":166910,"content":"1","priority":"n","name":"1","warningExpression":"1","criticalExpressionDescription":"","alarmCount":1,"notifyOk":"n"}],"type":"a","monitorItemTypeId":5,"id":6956,"collectUrl":"jmx:\/\/GetAttr\/com.amyliascarlet.dragoon:type=Exception(\"ErrorList\")","scheduleTimeout":5,"description":"exception","name":"exception","scheduleIntervalAlarm":15,"locked":"n","targetType":"a","scheduleInterval":60},{"opts":[""],"oldId":null,"gmtCreate":1290366943000,"status":null,"targetId":1920,"scheduleExpression":"[* * * * * ?]","alarmRules":[],"endTime":1291115681000,"type":"a","monitorItemTypeId":1,"startTime":1290424479000,"id":729245,"collectUrl":"jmx:\/\/GetAttr\/com.amyliascarlet.dragoon:type=Threading(\"DaemonThreadCount\", \"ThreadCount\", \"NewThreadCount\", \"RunnableThreadCount\", \"BlockedThreadCount\", \"WaitingThreadCount\", \"TimedWaitingThreadCount\", \"TeminatedThreadCount\", \"DeadLockedThreadCount\", \"TotalStartedThreadCount\", \"ProcessCpuTimeRate\", \"FullGCCollectionTimeRate\")","scheduleTimeout":5,"description":"jvm_threading","name":"jvm_threading1","scheduleIntervalAlarm":60,"locked":"n","targetType":"a","scheduleInterval":300},{"opts":["reset=true"],"oldId":null,"gmtCreate":1290004798000,"status":null,"targetId":23910,"scheduleExpression":"[* * * * * ?]","alarmRules":[],"endTime":1291097254000,"type":"a","monitorItemTypeId":5,"startTime":1290578853000,"id":609389,"collectUrl":"jmx:\/\/GetAttr\/com.amyliascarlet.dragoon:type=Exception(\"ErrorList\")","scheduleTimeout":5,"description":"exception","name":"exception","scheduleIntervalAlarm":60,"locked":"n","targetType":"a","scheduleInterval":300},{"opts":[],"oldId":null,"gmtCreate":1289246125000,"status":null,"targetId":691,"scheduleExpression":"[* * * * * ?]","alarmRules":[],"endTime":1320152730000,"type":"a","monitorItemTypeId":4,"startTime":1288612505000,"id":6954,"collectUrl":"jmx:\/\/GetAttr\/com.amyliascarlet.dragoon:type=JVM(\"PID\", \"StartTime\", \"InputArguments\", \"Arch\", \"OSName\", \"OSVersion\", \"JVM\", \"JavaVersion\", \"JavaHome\", \"JavaLibraryPath\", \"JavaSpecificationVersion\", \"AvailableProcessors\", \"LoadedClassCount\", \"TotalLoadedClassCount\", \"UnloadedClassCount\", \"TotalCompilationTime\")","scheduleTimeout":5,"description":"jvm_info","name":"jvm_info","scheduleIntervalAlarm":60,"locked":"n","targetType":"a","scheduleInterval":300},{"opts":[],"oldId":null,"gmtCreate":1289213019000,"status":null,"targetId":1920,"scheduleExpression":"[* * * * * ?]","alarmRules":[],"endTime":1288579301000,"type":"a","monitorItemTypeId":2,"startTime":1288579301000,"id":19219,"collectUrl":"jmx:\/\/GetAttr\/com.amyliascarlet.dragoon:type=Memory(\"MemoryHeapCommitted\", \"MemoryHeapUsed\", \"MemoryNonHeapCommitted\", \"MemoryNonHeapUsed\", \"UsedPhysicalMemorySize\", \"TotalPhysicalMemorySize\", \"UsedSwapSpaceSize\", \"TotalSwapSpaceSize\")","scheduleTimeout":5,"description":"desc1","name":"jvm_memory","scheduleIntervalAlarm":15,"locked":"n","targetType":"a","scheduleInterval":60},{"opts":["reset=true"],"oldId":null,"gmtCreate":1290505731000,"status":null,"targetId":78972,"scheduleExpression":"[* * * * * ?]","alarmRules":[],"endTime":1291081720000,"type":"a","monitorItemTypeId":5,"startTime":1290476915000,"id":78977,"collectUrl":"jmx:\/\/GetAttr\/com.amyliascarlet.dragoon:type=Exception(\"ErrorList\")","scheduleTimeout":5,"description":"exception hello","name":"exception1","scheduleIntervalAlarm":60,"locked":"y","targetType":"a","scheduleInterval":300},{"opts":[],"oldId":null,"gmtCreate":1289905053000,"status":null,"targetId":1920,"scheduleExpression":"[* * * * * ?]","alarmRules":[],"endTime":1301484117000,"type":"a","monitorItemTypeId":3,"startTime":1290597715000,"id":60927,"collectUrl":"jmx:\/\/GetAttr\/com.amyliascarlet.dragoon:type=GC(\"PermGenUsed\", \"OldGenUsed\", \"EdenSpaceUsed\", \"SurvivorSpaceUsed\", \"FullGCCollectionCount\", \"FullGCCollectionTime\", \"YoungGCCollectionCount\", \"YoungGCCollectionTime\")","scheduleTimeout":5,"description":"jvm_gc","name":"jvm_gc","scheduleIntervalAlarm":60,"locked":"n","targetType":"a","scheduleInterval":60},{"opts":[""],"oldId":null,"gmtCreate":1291041346000,"status":null,"targetId":13491,"scheduleExpression":"[* * * * * ?]","alarmRules":[{"criticalExpression":"@RunnableThreadCount>5","warningExpressionDescription":"","monitorItemId":134964,"alarmInterval":60,"alarmReceivers":[{"id":202945,"isUpgrade":"n","userId":609247,"receiveRuleId":839375,"alarmRuleId":202944}],"upgradeInterval":60,"id":202944,"content":"threading","priority":"n","name":"threading","warningExpression":"@RunnableThreadCount>1","criticalExpressionDescription":"","alarmCount":5,"notifyOk":"y"}],"endTime":1294468382000,"type":"a","monitorItemTypeId":1,"startTime":1291098773000,"id":134964,"collectUrl":"jmx:\/\/GetAttr\/com.amyliascarlet.dragoon:type=Threading(\"DaemonThreadCount\", \"ThreadCount\", \"NewThreadCount\", \"RunnableThreadCount\", \"BlockedThreadCount\", \"WaitingThreadCount\", \"TimedWaitingThreadCount\", \"TeminatedThreadCount\", \"DeadLockedThreadCount\", \"TotalStartedThreadCount\", \"ProcessCpuTimeRate\", \"FullGCCollectionTimeRate\")","scheduleTimeout":5,"description":"jvm_threading","name":"jvm_threading","scheduleIntervalAlarm":30,"locked":"y","targetType":"a","scheduleInterval":60},{"opts":["reset=true"],"oldId":null,"gmtCreate":1289213028000,"status":null,"targetId":1920,"scheduleExpression":"[* * * * * ?]","alarmRules":[{"criticalExpression":"@Count>=10","warningExpressionDescription":"","monitorItemId":19231,"alarmInterval":60,"alarmReceivers":[{"id":177989,"isUpgrade":"n","userId":1,"receiveRuleId":19261,"alarmRuleId":177988}],"upgradeInterval":60,"id":177988,"content":"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","priority":"n","name":"exception","warningExpression":"@Count>=5","criticalExpressionDescription":"","alarmCount":1,"notifyOk":"y"}],"endTime":1288579390000,"type":"a","monitorItemTypeId":5,"startTime":1288579390000,"id":19231,"collectUrl":"jmx:\/\/GetAttr\/com.amyliascarlet.dragoon:type=Exception(\"ErrorList\")","scheduleTimeout":5,"description":"exceptionaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","name":"exception","scheduleIntervalAlarm":15,"locked":"y","targetType":"a","scheduleInterval":60},{"opts":[],"oldId":null,"gmtCreate":1289213026000,"status":null,"targetId":1920,"scheduleExpression":"[* * * * * ?]","alarmRules":[{"criticalExpression":"@AvailableProcessors>=100","warningExpressionDescription":"","monitorItemId":19229,"alarmInterval":60,"alarmReceivers":[{"id":839389,"isUpgrade":"n","userId":1,"receiveRuleId":19261,"alarmRuleId":839388}],"upgradeInterval":60,"id":839388,"content":"@AvailableProcessors>=0","priority":"n","name":"AvailableProcessors","warningExpression":"@AvailableProcessors>=100","criticalExpressionDescription":"","alarmCount":1,"notifyOk":"y"}],"endTime":1289356974000,"type":"a","monitorItemTypeId":4,"startTime":1289356974000,"id":19229,"collectUrl":"jmx:\/\/GetAttr\/com.amyliascarlet.dragoon:type=JVM(\"PID\", \"StartTime\", \"InputArguments\", \"Arch\", \"OSName\", \"OSVersion\", \"JVM\", \"JavaVersion\", \"JavaHome\", \"JavaLibraryPath\", \"JavaSpecificationVersion\", \"AvailableProcessors\", \"LoadedClassCount\", \"TotalLoadedClassCount\", \"UnloadedClassCount\", \"TotalCompilationTime\")","scheduleTimeout":5,"description":"jvm_info","name":"jvm_info","scheduleIntervalAlarm":60,"locked":"n","targetType":"a","scheduleInterval":60}],"applications":[{"id":3,"description":"test","name":"Dragoon Test","number":"Dragoon Test","createDate":1293043940000},{"id":691,"description":"dragoon-master","name":"master","number":"master","createDate":1289245940000},{"id":1920,"description":"dragoon","name":"dragoon","number":"dragoon","createDate":1289163910000},{"id":13491,"description":"yuzefeng","name":"yzf_app","number":"yzf_app","createDate":1291039232000},{"id":23910,"description":"demo-inst1","name":"demo","number":"demo","createDate":1289472915000},{"id":23911,"description":"2.5��monitor","name":"dragoon-monitor","number":"dragoon-monitor","createDate":1289473324000},{"id":78972,"description":"This is an app","name":"luomingapp","number":"111222","createDate":1290505557000},{"id":171910,"description":"test","name":"test","number":"test","createDate":1291564140000}],"types":[{"opts":[],"scheduleExpression":null,"gatherType":"a","alarmRules":[],"type":null,"meta":"<?xml version=\"1.0\" encoding=\"utf-8\"?><meta tableName=\"m_jvm_threading\"><fields><field name=\"ProcessCpuTimeRate\" label=\"ProcessCpuTimeRate\" dbColumnName=\"CpuTimeRate\" valuePolicy=\"current\" dataType=\"int32\"\/><field name=\"RunnableThreadCount\" label=\"RunnableThreadCount\" dbColumnName=\"RunnableThread\" valuePolicy=\"current\" dataType=\"int32\" \/><field name=\"NewThreadCount\" label=\"NewThreadCount\" dbColumnName=\"NewThread\" valuePolicy=\"current\" dataType=\"int32\"\/><field name=\"TotalStartedThreadCount\" label=\"TotalStartedThreadCount\" dbColumnName=\"TotalStartedThread\" valuePolicy=\"current\" dataType=\"int32\"\/><field name=\"DeadLockedThreadCount\" label=\"DeadLockedThreadCount\" dbColumnName=\"DeadLockedThread\" valuePolicy=\"current\" dataType=\"int32\"\/><field name=\"BlockedThreadCount\" label=\"BlockedThreadCount\" dbColumnName=\"BlockedThread\" valuePolicy=\"current\" dataType=\"int32\"\/><field name=\"FullGCCollectionTimeRate\" label=\"FullGCCollectionTimeRate\" dbColumnName=\"FGCTimeRate\" valuePolicy=\"current\" dataType=\"int32\"\/><field name=\"WaitingThreadCount\" label=\"WaitingThreadCount\" dbColumnName=\"WaitingThread\" valuePolicy=\"current\" dataType=\"int32\"\/><field name=\"DaemonThreadCount\" label=\"DaemonThreadCount\" dbColumnName=\"DaemonThread\" valuePolicy=\"current\" dataType=\"int32\"\/><field name=\"TeminatedThreadCount\" label=\"TeminatedThreadCount\" dbColumnName=\"TeminatedThread\" valuePolicy=\"current\" dataType=\"int32\"\/><field name=\"ThreadCount\" label=\"ThreadCount\" dbColumnName=\"TotalThread\" valuePolicy=\"current\" dataType=\"int32\"\/><field name=\"TimedWaitingThreadCount\" label=\"TimedWaitingThreadCount\" dbColumnName=\"TimedWaitingThread\" valuePolicy=\"current\" dataType=\"int32\"\/><\/fields><\/meta>","id":1,"collectUrl":null,"scheduleTimeout":null,"description":"jvm_threading","name":"jvm_threading","scheduleIntervalAlarm":null,"scheduleInterval":null},{"opts":[],"scheduleExpression":null,"gatherType":"a","alarmRules":[],"type":null,"meta":"<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n<meta tableName=\"m_jvm_memory\">\r\n<fields>\r\n  <field name=\"UsedPhysicalMemorySize\" label=\"UsedPhysicalMemorySize\" dataType=\"int64\" dbColumnName=\"UsedPhysicalMemSize\" valuePolicy=\"current\" \/>\r\n  <field name=\"MemoryNonHeapCommitted\" label=\"MemoryNonHeapCommitted\" dataType=\"int64\" dbColumnName=\"MemNonHeapCommitted\" valuePolicy=\"current\" \/>\r\n  <field name=\"UsedSwapSpaceSize\" label=\"UsedSwapSpaceSize\" dataType=\"int64\" dbColumnName=\"UsedSwapSize\" valuePolicy=\"current\" \/>\r\n  <field name=\"TotalPhysicalMemorySize\" label=\"TotalPhysicalMemorySize\" dataType=\"int64\" dbColumnName=\"TotalPhysicalMemSize\" valuePolicy=\"current\" \/>\r\n  <field name=\"MemoryHeapUsed\" label=\"MemoryHeapUsed\" dataType=\"int64\" dbColumnName=\"MemHeapUsed\" valuePolicy=\"current\" \/>\r\n  <field name=\"MemoryHeapCommitted\" label=\"MemoryHeapCommitted\" dataType=\"int64\" dbColumnName=\"MemHeapCommitted\" valuePolicy=\"current\" \/>\r\n  <field name=\"TotalSwapSpaceSize\" label=\"TotalSwapSpaceSize\" dataType=\"int64\" dbColumnName=\"TotalSwapSize\" valuePolicy=\"current\" \/>\r\n  <field name=\"MemoryNonHeapUsed\" label=\"MemoryNonHeapUsed\" dataType=\"int64\" dbColumnName=\"MemNonHeapUsed\" valuePolicy=\"current\" \/>\r\n<\/fields>\r\n<\/meta>","id":2,"collectUrl":null,"scheduleTimeout":null,"description":"desc1","name":"jvm_memory","scheduleIntervalAlarm":null,"scheduleInterval":null},{"opts":[],"scheduleExpression":null,"gatherType":"a","alarmRules":[],"type":null,"meta":"<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n<meta tableName=\"m_jvm_gc\">\r\n<fields>\r\n  <field name=\"YoungGCCollectionTime\"  label=\"YoungGCCollectionTime\" dataType=\"int64\" dbColumnName=\"YGCTime\" valuePolicy=\"current\"\/>\r\n  <field name=\"FullGCCollectionTime\" label=\"FullGCCollectionTime\" dataType=\"int64\" dbColumnName=\"FGCTime\" valuePolicy=\"current\"\/>\r\n  <field name=\"FullGCCollectionCount\" label=\"FullGCCollectionCount\" dataType=\"int64\" dbColumnName=\"FGCCount\" valuePolicy=\"current\"\/>\r\n  <field name=\"PermGenUsed\" label=\"PermGenUsed\" dataType=\"int64\" dbColumnName=\"PermGenUsed\" valuePolicy=\"current\"\/>\r\n  <field name=\"SurvivorSpaceUsed\" label=\"SurvivorSpaceUsed\" dataType=\"int64\" dbColumnName=\"SurvivorUsed\" valuePolicy=\"current\"\/>\r\n  <field name=\"EdenSpaceUsed\" label=\"EdenSpaceUsed\" dataType=\"int64\" dbColumnName=\"EdenUsed\" valuePolicy=\"current\"\/>\r\n  <field name=\"YoungGCCollectionCount\" label=\"YoungGCCollectionCount\" dataType=\"int64\" dbColumnName=\"YGCCount\" valuePolicy=\"current\"\/>\r\n  <field name=\"OldGenUsed\" label=\"OldGenUsed\" dataType=\"int64\" dbColumnName=\"OldGenUsed\" valuePolicy=\"current\"\/>\r\n<\/fields>\r\n<\/meta>","id":3,"collectUrl":null,"scheduleTimeout":null,"description":"jvm_gc","name":"jvm_gc","scheduleIntervalAlarm":null,"scheduleInterval":null},{"opts":[],"scheduleExpression":null,"gatherType":"a","alarmRules":[],"type":null,"meta":"<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n<meta tableName=\"m_jvm_info\">\r\n<fields>\r\n  <field name=\"AvailableProcessors\" label=\"AvailableProcessors\" dataType=\"int32\" dbColumnName=\"AvailableCpus\" valuePolicy=\"current\"\/>\r\n  <field name=\"JavaHome\" label=\"JavaHome\" dataType=\"String\" dbColumnName=\"JavaHome\" valuePolicy=\"current\"\/>\r\n  <field name=\"JavaVersion\" label=\"JavaVersion\" dataType=\"String\" dbColumnName=\"JavaVersion\" valuePolicy=\"current\"\/>\r\n  <field name=\"PID\" label=\"PID\" dataType=\"String\" dbColumnName=\"PID\" valuePolicy=\"current\"\/>\r\n  <field name=\"OSVersion\" label=\"OSVersion\" dataType=\"String\" dbColumnName=\"OSVersion\" valuePolicy=\"current\"\/>\r\n  <field name=\"UnloadedClassCount\" label=\"UnloadedClassCount\" dataType=\"int64\" dbColumnName=\"UnloadedClass\" valuePolicy=\"current\"\/>\r\n  <field name=\"TotalCompilationTime\" label=\"TotalCompilationTime\" dataType=\"int64\" dbColumnName=\"TotalCompileTime\" valuePolicy=\"current\"\/>\r\n  <field name=\"OSName\" label=\"OSName\" dataType=\"String\" dbColumnName=\"OSName\" valuePolicy=\"current\"\/>\r\n  <field name=\"JavaSpecificationVersion\" label=\"JavaSpecificationVersion\" dataType=\"String\" dbColumnName=\"JavaSpecVersion\" valuePolicy=\"current\"\/>\r\n  <field name=\"Arch\" label=\"Arch\" dataType=\"String\" dbColumnName=\"Arch\" valuePolicy=\"current\"\/>\r\n  <field name=\"LoadedClassCount\" label=\"LoadedClassCount\" dataType=\"int32\" dbColumnName=\"LoadedClass\" valuePolicy=\"current\"\/>\r\n  <field name=\"StartTime\" label=\"StartTime\" dataType=\"DateTime\" dbColumnName=\"StartTime\" valuePolicy=\"current\"\/>\r\n  <field name=\"InputArguments\" label=\"InputArguments\" dataType=\"String\" dbColumnName=\"InputArgs\" valuePolicy=\"current\"\/>\r\n  <field name=\"JVM\" label=\"JVM\" dataType=\"String\" dbColumnName=\"JVM\" valuePolicy=\"current\"\/>\r\n  <field name=\"TotalLoadedClassCount\" label=\"TotalLoadedClassCount\" dataType=\"int64\" dbColumnName=\"TotalLoadedClass\" valuePolicy=\"current\"\/>\r\n  <field name=\"JavaLibraryPath\" label=\"JavaLibraryPath\" dataType=\"String\" dbColumnName=\"JavaLibPath\" valuePolicy=\"current\"\/>\r\n<\/fields>\r\n<\/meta>","id":4,"collectUrl":null,"scheduleTimeout":null,"description":"jvm_info","name":"jvm_info","scheduleIntervalAlarm":null,"scheduleInterval":null},{"opts":[],"scheduleExpression":null,"gatherType":"a","alarmRules":[],"type":null,"meta":"<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n<meta tableName=\"m_exception\">\r\n<fields>\r\n<field name=\"Count\" label=\"Count\" dataType=\"int64\" description=\"\" dbColumnName=\"ECount\" valuePolicy=\"current\"\/>\r\n  <field name=\"LastThrowMessage\" label=\"LastThrowMessage\" dataType=\"String\" description=\"\" dbColumnName=\"EMessage\" valuePolicy=\"current\"\/>\r\n  <field name=\"Method\" label=\"Method\" dataType=\"String\" description=\"\" dbColumnName=\"EMethod\" valuePolicy=\"current\"\/>\r\n  <field name=\"Type\" label=\"Type\" dataType=\"String\" description=\"\" dbColumnName=\"EType\" valuePolicy=\"current\"\/>\r\n  <field name=\"LastThrowDate\" label=\"LastThrowDate\" dataType=\"DateTime\" description=\"\" dbColumnName=\"EDATE\" valuePolicy=\"current\"\/>\r\n  <field name=\"StackTrace\" label=\"StackTrace\" dataType=\"String\" description=\"\" dbColumnName=\"EStackTrace\" valuePolicy=\"current\"\/>\r\n  <field name=\"URI\" label=\"URI\" dataType=\"String\" description=\"\" dbColumnName=\"EURI\" valuePolicy=\"current\"\/>\r\n<\/fields>\r\n<\/meta>","id":5,"collectUrl":null,"scheduleTimeout":null,"description":"exception hello","name":"exception1","scheduleIntervalAlarm":null,"scheduleInterval":null}],"version":"1965"
			}