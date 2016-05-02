/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgorithmTests;

/**
 *
 * @author tkasozi
 */

  public class Stopwatch {

        private final long start;

        public Stopwatch() {
            start = System.currentTimeMillis();
        }

        // return time (in seconds) since this object was created
        public double elapsedTime() {
            long now = System.currentTimeMillis();
            return (now - start) / 1000.0;
        }
    }