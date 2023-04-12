pipeline{
    agent {label 'docker'}
    environment {
		DOCKER_LOGIN_CREDENTIALS=credentials('Rajashekar85-Dockerhub')
	}
    stages {
        stage('checkout') {
            steps {
            git branch: 'main', url: 'https://github.com/Rajashekar85/rchidana-JacocoExample.git'
            }
        }

        stage('build') {
            steps {
                sh 'mvn clean package'
               }
        }
        stage('jacoco report') {
            steps {
                jacoco(
                    execPattern: '**/target/**.exec',
                    classPattern: '**/classes',
                    sourcePattern: '**/src/main/java'
                    exclusionPattern: '**/src/test'
                )
            }
        }
    }
}
