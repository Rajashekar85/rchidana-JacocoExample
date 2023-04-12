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
                sh 'docker build -t rajashekar85/jacoco:$BUILD_NUMBER .'
                }
        }

        stage('push') {
            steps {
                sh 'echo $DOCKER_LOGIN_CREDENTIALS_PSW | docker login -u $DOCKER_LOGIN_CREDENTIALS_USR --password-stdin'
                sh 'docker push rajashekar85/jacoco:$BUILD_NUMBER'
            }
        }

        stage('deploy') {
            steps {
                sh "docker run -itd -p 8080:8080 rajashekar85/jacoco:$BUILD_NUMBER"
            }
        }
    }
    post {
        always {
            sh 'docker logout'
        }
    }
}
