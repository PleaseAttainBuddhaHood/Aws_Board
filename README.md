# good
스프링 부트와 AWS로 혼자 구현하는 웹 서비스 - https://product.kyobobook.co.kr/detail/S000001019679   

책을 따라가며 가장 신경쓰이는 문제는 버전 호환.
각종 애너테이션, 메서드 등이 어떤게 적절할지, 이것 말고 다른 책에서 봤던 최신 메서드를 써볼지 
테스트하고 고민하는 과정이다.


# **[build.gradle]**   
: **JDK** 11    
: **boot** 2.6.8(머스테치 한글 깨짐 방지)   
: repositories만 **jcenter()** 추가했음   

<br>

# **[.ignore]**   
: **.ignore 파일**은 인텔리제이 기본 제공인듯?   
: idea와 gradle은 기본 이그노어 인듯   

<br>


# **assertThat vs assertTrue**   
: 스프링의 정석에서 쓰는 assertTrue 보단, **assertThat**이 더 낫다.   
 https://jongmin92.github.io/2020/03/31/Java/use-assertthat/   
 
 <br>
 
# **p100 application.properties 설정 변경**     
spring.jpa.properties.hibernate.dialect=**org.hibernate.dialect.MySQL57Dialect**   
spring.jpa.properties.hibernate.dialect.storage_engine=**innodb**   
spring.datasource.hikari.jdbc-url=**jdbc:h2:mem:testdb;MODE=MYSQL**    
https://github.com/jojoldu/freelec-springboot2-webservice/issues/612

<br>   

# **p.110 PostsApiControllerTests**   
: assertThat(responseEntity.getBody()).**isGreaterThan(0L)**;   
-> 둘의 차이는 뭘까? 아래가 인텔리제이 SonarLint에서 추천해주는 코드이긴한데..   
: assertThat(responseEntity.getBody()).**isPositive()**;   


<br>    

# **변수 모두 final로 변경**      
 - p.112 **PostsResponseDTO**      
 - p.149 **PostsListResponseDTO**     
 - p.185 **OAuthAttributes**      


<br>    
   
   
# **p218 PostsApiControllerTests**   
 - .contentType(**MediaType.APPLICATION_JSON_UTF8**) -> .contentType(**MediaType.APPLICATION_JSON**)   
   : **deprecated**   
   
<br>   
 

# **p258 AWS에 jdk 11 설치**         
 - aws coreetto 다운로드   
sudo curl -L https://corretto.aws/downloads/latest/amazon-corretto-11-x64-linux-jdk.rpm -o jdk11.rpm   
 - jdk11 설치   
sudo yum localinstall jdk11.rpm   
 - jdk version 선택   
sudo /usr/sbin/alternatives --config java   
 - java 버전 확인   
java --version   
 - 다운받은 설치키트 제거   
rm -rf jdk11.rpm   
   
참고 : https://acet.pe.kr/902   
   
<br>   
<br>   
   
# p.261 hostName 변경   
[as-is]   
$ sudo vim /etc/sysconfig/network      
[to-be]   
$ sudo hostnamectl set-hostname springboot-webservice   
$ sudo reboot   

참고: https://github.com/jojoldu/freelec-springboot2-webservice/issues/845   

<br><br>   

# p303 ./deploy.sh 명령어 실행 안되는 오류, oauth 로그인(구글, 네이버)시, 아이디 제대로 출력 안되는 오류 존재
![image](https://user-images.githubusercontent.com/83068670/206926211-95e42d59-e981-474a-9284-ad5b0f1df23b.png)   

![image](https://user-images.githubusercontent.com/83068670/206926243-96e924c4-b0d1-4313-85df-9cf1bfef40d6.png)

# p.311 파일 내용 확인   
: head nohup.out   

<br>    
#

