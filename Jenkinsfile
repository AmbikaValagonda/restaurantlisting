pipeline {
	
  agent any

  environment {
    DOCKERHUB_CREDENTIALS = credentials('DOCKER_HUB_CREDENTIALS')
    VERSION = "${env.BUILD_ID}"
  }

  tools {
    maven "Maven"
  }

  stages {

	    stage('Maven Build'){
	        steps{
	        bat 'mvn clean package  -DskipTests'
	        }
	    }
	    
	    
		  stage('Cleanup Workspace') {
	      	steps {
	        deleteDir()
	       
	      }
    }

}

}
