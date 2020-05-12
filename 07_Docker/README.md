# Introduction to Docker and Elastic Container Service (ECS)  

This tutorial is adapted from an excellent [Docker Tutorial](https://docker-curriculum.com/#introduction) by Prakhar Srivastav.

## What is Docker?  
Docker is a tool that allows developers to easily deploy their applications in a *container*. From the Docker website:

> Multiple languages, frameworks, architectures, and discontinuous interfaces between tools for each lifecycle stage creates enormous complexity. Docker simplifies and accelerates your workflow, while giving developers the freedom to innovate with their choice of tools, application stacks, and deployment environments for each project.

In other words, Dockers enable users to package an application with **all of its dependencies** into a standardized unit for software development.
Some benefits:
1. Docker allows users to deploy their apps consistently, regardless of the operating system of the target
2. Portability
3. Decoupling allows for more granular control over each container, which can be used for optimization.

## Getting Started   

We need to do some preparation before diving into Docker.

1. Create an account on [DockerHub](https://hub.docker.com/). Take note of your username, this will be used later on.
2. Download and install Docker to your system: [Mac](https://docs.docker.com/docker-for-mac/install/), [Windows](https://docs.docker.com/docker-for-windows/install/), or [Linux](https://docs.docker.com/engine/install/ubuntu/)

**Note**: If your machine is not compatible, you can use [Docker Toolbox](https://docs.docker.com/toolbox/overview/) instead.

## Hello World  
Once installed, open your Docker terminal and run the following command to test whether everything is set up perfectly.  

`docker run hello world`

![](images/1%20docker%20hello%20world.png)

**Q1: Describe where docker finds the *image* of hello-world**  
**Q2: What do you think happened when we call the function `run`?**

## Useful Docker Commands  

Let's use another *image* to run in docker.  
Type in `docker run busybox echo "hello from busybox"`

![](images/2%20busybox.png)

What we did above is load the busybox image into a docker container and *inside that*, call the echo function.
I hope by now you know what the `run` function does :) For more information about busybox, you can visit the link [here](https://hub.docker.com/_/busybox).

Another important function is `docker ps`. This function shows all containers that are running.

![](images/3%20docker%20ps.png)

Right now it's empty because we don't have any containers running. To see the history of containers, we use `docker ps -a`

![](images/4%20docker%20ps%20a.png)

To clear all stopped containers, we can use `docker container prune`

![](images/5%20prune.png)

Last but not least, we use `docker image` to see a list of images stored locally.
To delete an image, use `docker rmi [image ID]`

## Building a Docker Image  
Now we are going to create our own docker image. In this section, we will create an image that sandboxes a simple Flask application.
This application is a web app that will randomly load a cat `.gif`.

To start, please clone the following repo:

![](images/6%20clone.png)

**Note**: use a terminal to clone the repo and not from the Docker terminal

Locate the `Dockerfile` and open it. It should look something like this.

![](images/7%20dockerfile.png)

A Dockerfile is a simple text file that contains a list of commands that the Docker client calls while creating an image. 
It's a simple way to automate the image creation process. Let's go through it.
  
![](images/8%20from.png)  
We start with specifying our base image. Use the FROM keyword to do that. There are a lot of base images to choose from: python, ubuntu, etc.

![](images/9%20copy.png)   
The next step usually is to write the commands of copying the files and installing the dependencies. First, we set a working directory and then copy all the files for our app.

![](images/10%20dependency.png)   
Now, that we have the files, we can install the dependencies.

![](images/11%20expose.png)   
The next thing we need to specify is the port number that needs to be exposed. Since our flask app is running on port 5000, that's what we'll indicate.

![](images/12%20cmd.png)   
The last step is to write the command for running the application, which is simply - python ./app.py. We use the CMD command to do that -
The primary purpose of CMD is to tell the container which command it should run when it is started.  

To build the image, use the command `docker build`. Don't forget the `.` 
 at the end.
![](images/13%20build.png)  
Change 'aristonlim' to your **DockerHub username**. The process might look different than the screenshot: docker will pull a python image first if you don't have any. 

To check if it is built successfully, use the command `docker images`. You should see `yourusername/catnip`listed.

![](images/14%20images.png)

Now it's time to run our image! Type the following command. Don't forget to change `aristonlim` to your username.

![](images/15%20catnip.png)

Head over to `localhost:5000` on your browser to see the result.

![](images/16%20localhost.png)

**Note:** If you are using Docker Toolbox, you might not be able to connect to localhost. To solve this:

1. Find out which virtual machine your Docker terminal is using. You can find this at the beginning of your docker terminal. Mine is called `default`.   
![](images/17%20default.png)
2. Type `docker-machine stop [your machine name]`
3. Search for 'VirtualBox' on your computer.
4. Go to Settings -> Network -> Advanced -> Port Forwarding.
![](images/18%20network.png)
5. Add another port, give it any name, and set Host Port and Guest Port to 5000.
![](images/19%20port.png)
6. Back to Docker terminal, type `docker-machine start [your machine name]`.
7. Re-run the `docker run` command above. You should be able to see the web app on your browser.

Congrats on building your first Docker Image!

## Deploying Docker on ECS  

Now we will try to use multiple docker containers and deploy them to ECS. For this example, we will use a web app that displays the number of food trucks.

![](images/20%20foodtruck.png)  

The backend is built on Python (Flask) and the search function is provided by ElasticSearch. 
We can see that the application consists of a Flask backend server and an Elasticsearch service. A natural way to split this app would be to have two containers - 
one running the Flask process and another running the Elasticsearch (ES) process. That way if our app becomes popular, we can scale it by adding more containers depending on where the bottleneck lies.

### Building Foodtruck Image  

First, let's clone the repository from [here](https://github.com/aristonhariantolim/cctutorial-foodtruck). I have modified the codes from the original to hopefully make it less buggy.

Next step would be to build our food truck web app. Place the folder on your Home directory and use your docker terminal to get into the folder.

Use the following command to build your app:

`$ cd cctutorial-foodtruck`  
`$ docker build -t yourusername/foodtrucks-web .`

Now we want to put this image on the web so that later on we can use ECS to retrieve this image. To do this, we will login into our DockerHub account, and push this image there.

Type `docker login`. You will be asked to enter your credentials. Use your username and password for DockerHub.

When that's done, type `docker push yourusername/foodtrucks-web`.

### Configure ECS  

First step we need to do is to install CLI for ECS. Refer to [this document](https://docs.aws.amazon.com/AmazonECS/latest/developerguide/ECS_CLI_installation.html) on how to install.
Once that's done, test the installation by checking the version as shown below.

![](images/21%20ecs%20cli%20version.png)

Next, we will need to configure the CLI. Use your access key id and secret access key for the following command below.

`$ ecs-cli configure profile --profile-name ecs-foodtrucks --access-key $AWS_ACCESS_KEY_ID --secret-key $AWS_SECRET_ACCESS_KEY`

We also need a EC2 keypair. Go to [EC2 console](https://console.aws.amazon.com/ec2/v2/home?region=us-east-1#KeyPairs:) and create a keypair.

![](images/22%20ec2.png)

Take note of the name of the keypair as well as the region. For me, I use 'ecs_test' and 'us-east-1'.

Again, we configure the CLI. Type:

`$ ecs-cli configure --region us-east-1 --cluster foodtrucks`  

Make sure that the region is the **same region** as the region you created the EC2 keypair.

Now we are ready to create the cluster on ECS. Type:

![](images/23%20ecs-cli.png)

Our cluster is created! All we need is to run the images on the containers on ECS.

**Q3: What do you think all the parameters mean?**

### Docker Compose  
Go to `aws-ecs` folder. Inside, you will find a `docker-compose.yml`. Open it up and see what's inside.

![](images/24%20yml.png)

Change the web image to `your username/foodtrucks-web` and save.

ECS will use this file to create 2 containers, one called `es`, where we will store our elasticsearch image, and one of our foodtrucks image. Since we already pushed our image to docker hub, ECS will be able to find the exact image.

To deploy our app on ECS, simply type:

`$ cd aws-ecs`  
`$ ecs-cli compose up`

If everything works correctly, the last 2 lines will say `lastStatus=RUNNING` as shown below.

![](images/25%20compose%20up.png)

Now, to access the website, type `ecs-cli ps`

![](images/26%20ecs%20ps.png)

Go to the address on the port and you should be able to see the web app!

Don't forget to turn off the cluster after you're done.

![](images/27%20ecs%20down.png)

**Q4: Can you think of a good use case of using multiple Docker containers for your project?**

**Q5: What is the most interesting thing you have learnt in this tutorial? What are the problems and how do you solve them?**



