## nginx转发动态IP

* 通过服务器A的nginx转发到服务器B，服务器B的IP是动态变化的。
* 在服务器B的IP变化时通知到服务器A，修改A的nginx.conf文件并重启nginx