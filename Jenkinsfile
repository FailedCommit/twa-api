
pipeline {
    agent {
        docker {
        image 'maven'
        args '-v /root/.m2:/root/.m2'
       }
    }
    stages {
        stage('Compile') {
            steps {
                sh 'mvn clean compile'
            }
        } 
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Package') {
            steps {
                sh 'mvn -B -DskipTests package'
            }
        }        
    }
}
