pipeline {
    agent { docker { image 'maven-chrome' } }
    stages {
        stage('build') {
            steps {
                sh 'mvn --version'
            }
        }
    }
}
