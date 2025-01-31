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
	        sh 'mvn clean package  -DskipTests'
	        }
	    }
	    
		 stage('Docker Build and Push') {
	      	steps {
	          sh 'echo ${DOCKERHUB_CREDENTIALS_PSW} | docker login -u ${DOCKERHUB_CREDENTIALS_USR} --password-stdin'
	          sh 'docker build -t ambikavalagonda/restaurant-listing-service:${VERSION} .'
	          sh 'docker push ambikavalagonda/restaurant-listing-service:${VERSION}'
	      }
	    } 
	    
		  stage('Cleanup Workspace') {
	      	steps {
	        deleteDir()
	       
	      }
    }

}

}
