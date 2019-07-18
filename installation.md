# Active MQ Installation

#### Installation (Active MQ in EC2)
* Download and Extract
```
wget https://my-project-builds.s3.amazonaws.com/apache-activemq-5.15.9-bin.tar.gz
tar -zxvf apache-activemq-5.15.9-bin.tar.gz
```

#### Update Configuration ( conf/activemq.xml)
* Update your EC2 IP 
```
 <transportConnector name="openwire" uri="tcp://ec2-3-91-78-239.compute-1.amazonaws.com:61616?maximumConnections=1000&amp;wireFormat.maxFrameSize=104857600"/>
 ```

#### Start Active MQ Server (bin folder)
```
java -jar activemq.jar start
```

#### EC2 - Allow Ports in EC2 Security Groups
* 8161
* 61616

#### Test URL
* http://ec2-3-91-78-239.compute-1.amazonaws.com:8161

Note: Admin Username/Password: admin/admin

