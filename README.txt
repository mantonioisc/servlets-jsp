#Imported to git on Feb/17/2014 with:
$ git svn clone --authors-file=users.txt --no-metadata  svn://blake/servlets-jsp  servlets-jsp

CREACION DEL PROYECTO
$ mvn archetype:create -DgroupId=examples -DartifactId=servlets-jsp -DpackageName=examples.servlets -DarchetypeArtifactId=maven-archetype-webapp

IMPORTACION A SUBVERSION
svn import servlets-jsp svn://localhost/servlets-jsp
Especificar el directorio de nuevo ya que pondría los recursos en raíz sin

CORRER EL PROYECTO
Se puede correr con jetty o tomcat
+Con jetty ejecutar
	mvn jetty:run
+Con tomcat
	Definir CATALINA_HOME a donde esta el tomcat
	Meter esta entrada al archivo tomcat-users.xml
		<role rolename="manager"/>
  		<role rolename="standard"/>
  		<user username="admin" password="" roles="standard,manager"/>
  		Iniciar tomcat normalmente
  	Correr para mover el war a tomcat, arrancarlo
  		mvn tomcat:deploy
  		mvn tomcat:start
  	Para pararlo
  		mvn tomcat:stop
  	Para pararlo y desdeployarlo
  		mvn tomcat:undeploy
	Tambien se puede usar tomcat:redeploy para evitarse tantos pasos
	Para más información de tomcat 
		$ mvn help:describe -Dplugin=tomcat

DESCRIPCION
	+Login
	Solo esta protegidas por login las paginas en el folder secured/
	Las páginas de login estan en el folder login/ y la configuración esta en el web.xml <login-config>
	Para las partes de la aplicación con login, copiar esto a $CATALINA_HOME/conf/tomcat-users.xml
	<tomcat-users>
  		<role rolename="junker"/>
  		<user username="gillian" password="seed" roles="junker"/>
	</tomcat-users>
	Y deployar la aplicación a tomcat. Esto solo funcionará en tomcat todo lo demás debería ser accesible con otro server.
	+Login Jetty
	Se creo un jetty-web.xml y se hace referencia a un security realm en un property file donde se definen lo usuarios
	No se necesita hacer más que jetty:run
