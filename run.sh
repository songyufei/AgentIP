#!/bin/sh
SHUTDOWN_WAIT=40
#pid=`jps|grep -v Jps|awk '{print $1}'`
JAVA_APP="com.silence.agentip.crawler.Application"
pid=`$JAVA_HOME/bin/jps -l |grep $JAVA_APP |awk '{print $1}'`
echo $pid
if [ -n "$pid" ]
then
        echo -e "\e[00;31mStoping java\e[00m"
        kill $pid
        let kwait=$SHUTDOWN_WAIT
        count=0;
        until  [ `ps -p $pid | grep -c $pid` = '0' ] || [ $count -gt $kwait ]
        do
                echo -n -e "\n\e[00;31mwaiting for processes to exit\e[00m";
                sleep 1
                let count=$count+1;
        done
        if [ $count -gt $kwait ]; then
                echo -n -e "\n\e[00;31mkilling -9 processes which didn't stop after $SHUTDOWN_WAIT seconds\e[00m"
                kill -9 $pid
        fi
fi
echo -n -e "\n\e[00;31mSTART PROCESS\e[00m\n";

echo $JAVA_HOME

APP_HOME=/silence/application/agent-ip-crawler

CLASSPATH=$APP_HOME/conf
for i in "$APP_HOME"/lib/*.jar; do
   CLASSPATH="$CLASSPATH":"$i"
done

JAVA_OPTS_MEM="-server -Xms256M -Xmx700M"
JAVA_OPTS="-Dfile.encoding=UTF8 -Dsun.jnu.encoding=UTF8"
#JAVA_CMD="nohup $JAVA_HOME/bin/java $JAVA_OPTS_MEM $JAVA_OPTS_GC $JAVA_OPTS_ERROR -jar $JAVA_APP >/dev/null 2>&1  &"
echo "JAVA_OPTS_MEM:" $JAVA_OPTS_MEM
echo "JAVA_OPTS:" $JAVA_OPTS
#echo $JAVA_CMD
#su - root -c "$JAVA_CMD"
nohup $JAVA_HOME/bin/java $JAVA_OPTS_MEM $JAVA_OPTS -classpath $CLASSPATH $JAVA_APP >/dev/null 2>&1  &
pid=`$JAVA_HOME/bin/jps -l |grep $JAVA_APP |awk '{print $1}'`
if [ -n "$pid" ]
then
	echo $pid
	echo -e "\e[00;31mStart java success\e[00m"
else
	echo -e "\e[00;31mStart java failed\e[00m"
fi