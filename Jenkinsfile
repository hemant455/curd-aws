pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    stages {

        stage('Clone') {
            steps {
                git 'https://github.com/hemant455/curd-aws.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Docker Build') {
            steps {
                bat 'docker build -t springboot-curd-app .'
            }
        }

        stage('Docker Run') {
            steps {
                bat 'docker run -d -p 9090:9090 springboot-curd-app'
            }
        }
    }
}