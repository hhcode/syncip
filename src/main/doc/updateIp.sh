#! /bin/bash

source /etc/profile

ip=`curl ip.6655.com/ip.aspx`

date=`date`

echo $date $ip  >> /root/updateIp.log

curl http://mrhuang.online:11111/syncip?ip=$ip

