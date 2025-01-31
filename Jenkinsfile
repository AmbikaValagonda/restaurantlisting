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
		script {
		    echo "Docker Username: $DOCKER_HUB_CREDENTIALS_USR"
                    echo "Docker Password: $DOCKER_HUB_CREDENTIALS_PSW"
		}
	          bat 'echo $DOCKER_HUB_CREDENTIALS_PSW | docker login -u $DOCKER_HUB_CREDENTIALS_USR --password-stdin'
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
