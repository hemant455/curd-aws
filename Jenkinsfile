pipeline {
    agent any

    tools {
        maven 'Maven3'
    }

    stages {

        stage('Clone') {
            steps {
                git branch: 'main', url: 'https://github.com/hemant455/curd-aws.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t springboot-curd-app .'
            }
        }

        stage('Docker Run') {
            steps {
                sh 'docker run -d -p 9090:9090 springboot-curd-app'
            }
        }
    }
}