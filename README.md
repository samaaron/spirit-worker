# spirit-worker

A super simple worker library. Each worker is backed by a separate thread and receives and executes argless functions (thunks) sent to its queue.

## Dependencies

`spirit-worker` has the following dependencies:

* [Clojure 1.2](http://clojure.org)

## Installation

Simply add `spirit-worker` to the list of dependencies in your `project.clj`:

    (defproject your-project "0.1.5"
      :description "Your fabulous project that uses a spirit-worker
      :dependencies [[org.clojure/clojure "1.2.0"]
                     [spirit-worker "0.0.1"]])

(Where `0.0.1` is replaced with the version you wish to use.)

Then run `cake deps` and cake will pull the library into your project's `lib` directory.

## Usage

### Creating a spirit worker

Simply use the `spirit` function:

    (spirit)

You will want to bind the result so that you may send jobs to the spirit:

    (def s (spirit))

This will create a new spirit worker and start it running. It runs in its own separate thread and will block when waiting for new jobs

### Sending jobs to a spirit worker

Once you have summoned a spirit, you may send it work in the form of thunks. A thunk is simply an argless function. Sending jobs is achieved using the `elicit` function:

    (elicit s #(println "hi"))

This will print `"hi"` to stdout (unless your setup is otherwise configured - for example, cake's stdout for non-repl threads is piped to `.cake/cake.log`).

## Contributors

* Sam Aaron

## License

Copyright (C) 2011 Sam Aaron

Distributed under the Eclipse Public License, the same as Clojure.
