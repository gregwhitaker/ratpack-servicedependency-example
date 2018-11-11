# ratpack-servicedependency-example
[![Build Status](https://travis-ci.org/gregwhitaker/ratpack-servicedependency-example.svg?branch=master)](https://travis-ci.org/gregwhitaker/ratpack-servicedependency-example)

An example of how to control the ordering of service startup and shutdown in [Ratpack](https://ratpack.io).

## Running the Example
Follow the steps below to run the example:

1. Run the following command to start the application:

        ./gradlew run
        
    In the terminal you will notice that the service started in the order `A -> B -> C -> D`:

        09:46:08.594 [main] INFO  ratpack.server.RatpackServer - Starting server...
        09:46:08.642 [main] INFO  ratpack.server.RatpackServer - Building registry...
        09:46:09.058 [main] INFO  ratpack.server.RatpackServer - Initializing 4 services...
        Starting ServiceA
        Starting ServiceB
        Starting ServiceC
        Starting ServiceD
        09:46:09.131 [main] INFO  ratpack.server.RatpackServer - Ratpack started for http://localhost:5050
        
3. Stop the application and modify the `config.yml` file as follows:

        serviceDependencies:
          #serviceC: ServiceB   # A -> B -> C -> D
          serviceC: ServiceD    # A -> B -> D -> C
          
4. Run the following command to start the application again:

        ./gradlew run
        
    In the terminal you will notice that the service started in the order `A -> B -> D -> C`:
        
        09:58:32.745 [main] INFO  ratpack.server.RatpackServer - Starting server...
        09:58:32.789 [main] INFO  ratpack.server.RatpackServer - Building registry...
        09:58:33.186 [main] INFO  ratpack.server.RatpackServer - Initializing 4 services...
        Starting ServiceA
        Starting ServiceB
        Starting ServiceD
        Starting ServiceC
        09:58:33.258 [main] INFO  ratpack.server.RatpackServer - Ratpack started (development) for http://localhost:5050
        
On application shutdown the services will terminate in the opposite order that they started.

## Bugs and Feedback
For bugs, questions, and discussions please use the [Github Issues](https://github.com/gregwhitaker/ratpack-servicedependency-example/issues).

## License
MIT License

Copyright (c) 2018 Greg Whitaker

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.