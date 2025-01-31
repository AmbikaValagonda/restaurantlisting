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
	    
		 stage('Docker Build and Push') {
	      	steps {
	          bat 'echo BeGrateful059* | docker login -u ambikavalagonda --password-stdin'
	          bat 'docker build -t ambikavalagonda/restaurant-listing-service:${VERSION} .'
	          bat 'docker push ambikavalagonda/restaurant-listing-service:${VERSION}'
	      }
	    } 
	    
		  stage('Cleanup Workspace') {
	      	steps {
	        deleteDir()
	       
	      }
    }

}

}
