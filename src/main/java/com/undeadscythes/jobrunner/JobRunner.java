/*
 * Copyright (C) 2014 UndeadScythes <udscythes@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.undeadscythes.jobrunner;

/**
 *
 * @author UndeadScythes <udscythes@gmail.com>
 */
public class JobRunner implements Runnable {
    public static Thread run(JobMarker job, JobDirector checker) {
        JobRunner bgJob = new JobRunner(job, checker);
        Thread thread = new Thread(bgJob);
        thread.start();
        return thread;
    }

    private final JobMarker job;
    private final JobDirector director;
    
    private JobRunner(JobMarker job, JobDirector director) {
        this.job = job;
        this.director = director;
    }
    
    @Override
    public void run() {
        director.run(job);
    }
}
