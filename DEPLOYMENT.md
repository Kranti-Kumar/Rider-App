# Deployment Guide

## Prerequisites

1. PostgreSQL database (AWS RDS, local, or cloud)
2. Docker (for containerized deployment)
3. AWS Account (for AWS deployment)
4. Environment variables configured

## Required Environment Variables

Set these environment variables in your deployment environment:

```bash
# Database Configuration
DB_HOST_URL=your-database-host
DB_NAME=your_database_name
DB_USERNAME=your_database_user
DB_PASSWORD=your_database_password

# Security
JWT_SECRET_KEY=your_jwt_secret_key_here

# Mail Configuration (Optional)
MAIL_HOST=smtp.gmail.com
MAIL_PORT=587
MAIL_USERNAME=your_email@gmail.com
MAIL_PASSWORD=your_app_password
```

## Deployment Options

### Option 1: AWS CodeBuild + Docker (Recommended)

Your `buildspec.yml` is configured for AWS CodeBuild.

**Steps:**

1. **Push code to GitHub:**
   ```bash
   git add .
   git commit -m "Ready for deployment"
   git push origin main
   ```

2. **Setup AWS CodeBuild:**
   - Go to AWS CodeBuild console
   - Create a new build project
   - Connect to your GitHub repository
   - Set environment variables:
     - `DOCKER_USERNAME` - Your Docker Hub username
     - `DOCKER_PASSWORD` - Your Docker Hub password

3. **Run the build:**
   - CodeBuild will automatically:
     - Build the application
     - Run tests
     - Create Docker image
     - Push to Docker Hub

4. **Deploy the Docker container:**
   - Pull image: `docker pull YOUR_DOCKER_USERNAME/uberapp:latest`
   - Run container with environment variables

### Option 2: Local Docker Deployment

**Build and run locally:**

```bash
# 1. Build the JAR file
mvn clean package -DskipTests

# 2. Build Docker image
docker build -t uberapp:latest .

# 3. Run the container
docker run -d \
  -p 8080:8080 \
  -e DB_HOST_URL=your-db-host \
  -e DB_NAME=your_db \
  -e DB_USERNAME=your_user \
  -e DB_PASSWORD=your_password \
  -e JWT_SECRET_KEY=your_jwt_secret \
  --name uberapp \
  uberapp:latest
```

### Option 3: AWS Elastic Beanstalk

**Steps:**

1. Install EB CLI:
   ```bash
   pip install awsebcli
   ```

2. Initialize EB:
   ```bash
   eb init -p docker uberapp
   ```

3. Create environment:
   ```bash
   eb create uberapp-env
   ```

4. Set environment variables:
   ```bash
   eb setenv DB_HOST_URL=your-db-host \
            DB_NAME=your_db \
            DB_USERNAME=your_user \
            DB_PASSWORD=your_password \
            JWT_SECRET_KEY=your_jwt_secret
   ```

5. Deploy:
   ```bash
   eb deploy
   ```

### Option 4: AWS ECS (Elastic Container Service)

1. Push Docker image to ECR (AWS Container Registry) or Docker Hub
2. Create ECS task definition with environment variables
3. Create ECS service
4. Configure load balancer on port 8080

### Option 5: Manual Deployment on EC2

**Steps:**

1. **Launch EC2 instance** (Ubuntu 20.04 or Amazon Linux 2)

2. **Install Java 17+ and PostgreSQL client:**
   ```bash
   # Ubuntu
   sudo apt update
   sudo apt install openjdk-17-jdk postgresql-client

   # Amazon Linux 2
   sudo yum install java-17-amazon-corretto postgresql
   ```

3. **Clone and build:**
   ```bash
   git clone your-repo-url
   cd uberApp
   mvn clean package -DskipTests
   ```

4. **Run application:**
   ```bash
   java -jar target/uberApp-0.0.1-SNAPSHOT.jar \
     --spring.profiles.active=prod \
     --spring.datasource.url=jdbc:postgresql://DB_HOST:5432/DB_NAME \
     --spring.datasource.username=DB_USER \
     --spring.datasource.password=DB_PASS \
     --jwt.secretKey=JWT_SECRET
   ```

## Database Setup

**Before deploying, ensure your PostgreSQL database is ready:**

```sql
-- Connect to PostgreSQL
CREATE DATABASE your_database_name;

-- The application will create tables automatically with hibernate
-- Or run your schema scripts if you have any
```

## Health Check

After deployment, verify the application is running:

```bash
# Check if app is running
curl http://localhost:8080/actuator/health

# Or if deployed on cloud
curl http://your-domain.com/actuator/health
```

## Application Endpoints

- **API Base URL:** `http://your-domain:8080`
- **Auth Endpoints:**
  - POST `/auth/signup` - User registration
  - POST `/auth/login` - User login
  - POST `/auth/refresh` - Refresh token
  - POST `/auth/onBoardNewDriver/{userId}` - Onboard driver

- **Rider Endpoints:** (Requires ROLE_RIDER)
  - POST `/riders/requestRide`
  - POST `/riders/cancelRide/{rideId}`
  - GET `/riders/getMyProfile`
  - GET `/riders/getMyRides`

- **Driver Endpoints:** (Requires ROLE_DRIVER)
  - POST `/drivers/acceptRide/{rideRequestId}`
  - POST `/drivers/startRide/{rideRequestId}`
  - POST `/drivers/endRide/{rideId}`
  - GET `/drivers/getMyProfile`
  - GET `/drivers/getMyRides`

## Troubleshooting

1. **Application won't start:**
   - Check environment variables are set correctly
   - Verify database connection
   - Check logs: `docker logs uberapp`

2. **Database connection errors:**
   - Verify database is accessible
   - Check firewall rules
   - Verify credentials

3. **Mail service errors:**
   - Mail is optional - app will start without it
   - Verify MAIL_USERNAME and MAIL_PASSWORD if using email

## Next Steps After Deployment

1. Set up SSL certificate (HTTPS)
2. Configure load balancer
3. Set up monitoring and logging
4. Configure auto-scaling
5. Set up CI/CD pipeline for automatic deployments

