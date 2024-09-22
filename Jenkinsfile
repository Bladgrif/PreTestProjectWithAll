pipeline {
    agent any

    stages {
        stage('Setup') {
            steps {
                // Установить права на выполнение
                sh 'chmod +x ./gradlew'
            }
        }
        stage('Run Unit and API Tests') {
            parallel {
                stage('Unit Tests') {
                    steps {
                        sh './gradlew unit_tests'
                    }
                }
                stage('API Tests') {
                    steps {
                        sh './gradlew api_tests'
                    }
                }
            }
        }
    }

    post {
        always {
            junit 'build/test-results/**/*.xml'
        }
    }
}
