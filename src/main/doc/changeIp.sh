#!/bin/bash

oldIp=$1
newIp=$2

echo $oldIp
echo $newIp
sed -i "s/$oldIp/$newIp/g" /etc/nginx/nginx.conf
echo $newIp > /etc/nginx/ip

nginx -s reload
