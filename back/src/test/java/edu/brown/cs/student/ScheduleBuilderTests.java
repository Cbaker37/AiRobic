package edu.brown.cs.student;

import edu.brown.cs.student.main.models.ScheduleBuilder;
import edu.brown.cs.student.main.models.exceptions.InvalidDistributionException;
import edu.brown.cs.student.main.models.formattypes.Day;
import edu.brown.cs.student.main.models.formattypes.Day.WorkoutDescription;
import edu.brown.cs.student.main.models.formattypes.Schedule;
import edu.brown.cs.student.main.models.formattypes.Week;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ScheduleBuilderTests {

  /**
   * Tests that building a schedule with an allowed number of minutes (in the middle of the range)
   * produces a valid schedule.
   */
  @Test
  public void testScheduleBuilderMedium() {
    Schedule schedule = null;
    try {
      schedule = new ScheduleBuilder().minutes(600, 4, 0.2,
          "Tuesday", "Friday", "2k", "UT2");
    } catch (InvalidDistributionException e) {
      Assertions.assertEquals("All distributions were valid", e.getMessage());
    }
    Assertions.assertTrue(schedule.weeks().size() == 4);
    Assertions.assertEquals(schedule.example(), new Week("week", List.of(
        new Day("day", new ArrayList<>(), 2, "Monday",
            List.of(new WorkoutDescription("UT2", 60),
                new WorkoutDescription("2k", 60)), new ArrayList<>()),
        new Day("day", new ArrayList<>(), 2, "Tuesday",
            List.of(new WorkoutDescription("UT2", 60),
                new WorkoutDescription("UT2", 60)), new ArrayList<>()),
        new Day("day", new ArrayList<>(), 1, "Wednesday",
            List.of(new WorkoutDescription("UT2", 60)), new ArrayList<>()),
        new Day("day", new ArrayList<>(), 2, "Thursday",
            List.of(new WorkoutDescription("UT2", 60),
                new WorkoutDescription("2k", 60)), new ArrayList<>()),
        new Day("day", new ArrayList<>(), 2, "Friday",
            List.of(new WorkoutDescription("UT2", 60),
                new WorkoutDescription("UT2", 60)), new ArrayList<>()),
        new Day("day", new ArrayList<>(), 1, "Saturday",
            List.of(new WorkoutDescription("UT2", 60)), new ArrayList<>()),
        new Day("day", new ArrayList<>(), 0, "Sunday",
            List.of(), new ArrayList<>())
    )));
  }

  /**
   * Tests that building a schedule with an allowed number of minutes (at the max end of the range)
   * produces a valid schedule.
   */
  @Test
  public void testScheduleBuilderMax() {
    Schedule schedule = null;
    try {
      schedule = new ScheduleBuilder().minutes(1200, 5, 0.2,
          "Tuesday", "Friday", "2k", "UT2");
    } catch (InvalidDistributionException e) {
      Assertions.assertEquals("All distributions were valid", e.getMessage());
    }
    Assertions.assertTrue(schedule.weeks().size() == 5);
    Assertions.assertEquals(schedule.example(), new Week("week", List.of(
        new Day("day", new ArrayList<>(), 2, "Monday",
            List.of(new WorkoutDescription("UT2", 160),
                new WorkoutDescription("2k", 60)), new ArrayList<>()),
        new Day("day", new ArrayList<>(), 2, "Tuesday",
            List.of(new WorkoutDescription("UT2", 160),
                new WorkoutDescription("2k", 60)), new ArrayList<>()),
        new Day("day", new ArrayList<>(), 1, "Wednesday",
            List.of(new WorkoutDescription("UT2", 160)), new ArrayList<>()),
        new Day("day", new ArrayList<>(), 2, "Thursday",
            List.of(new WorkoutDescription("UT2", 160),
                new WorkoutDescription("2k", 60)), new ArrayList<>()),
        new Day("day", new ArrayList<>(), 2, "Friday",
            List.of(new WorkoutDescription("UT2", 160),
                new WorkoutDescription("2k", 60)), new ArrayList<>()),
        new Day("day", new ArrayList<>(), 1, "Saturday",
            List.of(new WorkoutDescription("UT2", 160)), new ArrayList<>()),
        new Day("day", new ArrayList<>(), 0, "Sunday",
            List.of(), new ArrayList<>())
    )));
  }

  /**
   * Tests that building a schedule with an allowed number of minutes (at the min end of the range)
   * produces a valid schedule.
   */
  @Test
  public void testScheduleBuilderMin() {
    Schedule schedule = null;
    try {
      schedule = new ScheduleBuilder().minutes(120, 4, 0.2,
          "Tuesday", "Friday", "2k", "UT2");
    } catch (InvalidDistributionException e) {
      Assertions.assertEquals("All distributions were valid", e.getMessage());
    }
    Assertions.assertTrue(schedule.weeks().size() == 4);
    Assertions.assertEquals(schedule.example(), new Week("week", List.of(
        new Day("day", new ArrayList<>(), 1, "Monday",
            List.of(new WorkoutDescription("2k", 60)), new ArrayList<>()),
        new Day("day", new ArrayList<>(), 0, "Tuesday",
            List.of(), new ArrayList<>()),
        new Day("day", new ArrayList<>(), 0, "Wednesday",
            List.of(), new ArrayList<>()),
        new Day("day", new ArrayList<>(), 1, "Thursday",
            List.of(new WorkoutDescription("UT2", 60)), new ArrayList<>()),
        new Day("day", new ArrayList<>(), 0, "Friday",
            List.of(), new ArrayList<>()),
        new Day("day", new ArrayList<>(), 0, "Saturday",
            List.of(), new ArrayList<>()),
        new Day("day", new ArrayList<>(), 0, "Sunday",
            List.of(), new ArrayList<>())
    )));
  }

  /**
   * Tests that building a schedule with an allowed number of minutes (in the middle of the range)
   * and varying the high intensity workout percentage produces a valid schedule.
   */
  @Test
  public void testScheduleBuilderMediumChangeHigh() {
    Schedule schedule = null;
    try {
      schedule = new ScheduleBuilder().minutes(600, 4, 0.1,
          "Tuesday", "Friday", "2k", "UT2");
    } catch (InvalidDistributionException e) {
      Assertions.assertEquals("All distributions were valid", e.getMessage());
    }
    Assertions.assertTrue(schedule.weeks().size() == 4);
    Assertions.assertEquals(schedule.example(), new Week("week", List.of(
        new Day("day", new ArrayList<>(), 2, "Monday",
            List.of(new WorkoutDescription("UT2", 60),
                new WorkoutDescription("2k", 60)), new ArrayList<>()),
        new Day("day", new ArrayList<>(), 2, "Tuesday",
            List.of(new WorkoutDescription("UT2", 60),
                new WorkoutDescription("UT2", 60)), new ArrayList<>()),
        new Day("day", new ArrayList<>(), 1, "Wednesday",
            List.of(new WorkoutDescription("UT2", 60)), new ArrayList<>()),
        new Day("day", new ArrayList<>(), 2, "Thursday",
            List.of(new WorkoutDescription("UT2", 60),
                new WorkoutDescription("UT2", 60)), new ArrayList<>()),
        new Day("day", new ArrayList<>(), 2, "Friday",
            List.of(new WorkoutDescription("UT2", 60),
                new WorkoutDescription("UT2", 60)), new ArrayList<>()),
        new Day("day", new ArrayList<>(), 1, "Saturday",
            List.of(new WorkoutDescription("UT2", 60)), new ArrayList<>()),
        new Day("day", new ArrayList<>(), 0, "Sunday",
            List.of(), new ArrayList<>())
    )));
    Assertions.assertEquals(schedule.weeks().get(1), schedule.example());

    try {
      schedule = new ScheduleBuilder().minutes(600, 4, 0.4,
          "Tuesday", "Friday", "2k", "UT2");
    } catch (InvalidDistributionException e) {
      Assertions.assertEquals("All distributions were valid", e.getMessage());
    }
    Assertions.assertTrue(schedule.weeks().size() == 4);
    Assertions.assertEquals(schedule.example(), new Week("week", List.of(
        new Day("day", new ArrayList<>(), 2, "Monday",
            List.of(new WorkoutDescription("UT2", 60),
                new WorkoutDescription("2k", 60)), new ArrayList<>()),
        new Day("day", new ArrayList<>(), 2, "Tuesday",
            List.of(new WorkoutDescription("UT2", 60),
                new WorkoutDescription("2k", 60)), new ArrayList<>()),
        new Day("day", new ArrayList<>(), 1, "Wednesday",
            List.of(new WorkoutDescription("UT2", 60)), new ArrayList<>()),
        new Day("day", new ArrayList<>(), 2, "Thursday",
            List.of(new WorkoutDescription("UT2", 60),
                new WorkoutDescription("2k", 60)), new ArrayList<>()),
        new Day("day", new ArrayList<>(), 2, "Friday",
            List.of(new WorkoutDescription("UT2", 60),
                new WorkoutDescription("2k", 60)), new ArrayList<>()),
        new Day("day", new ArrayList<>(), 1, "Saturday",
            List.of(new WorkoutDescription("UT2", 60)), new ArrayList<>()),
        new Day("day", new ArrayList<>(), 0, "Sunday",
            List.of(), new ArrayList<>())
    )));
    Assertions.assertEquals(schedule.weeks().get(1), schedule.example());
  }

  /**
   * Tests that building a schedule with an allowed number of minutes (in the middle of the range)
   * and varying the high intensity workout percentage produces a valid schedule.
   */
  @Test
  public void testScheduleBuilderBadHigh() {
    Exception exn =
        Assertions.assertThrows(
            InvalidDistributionException.class,
            () -> {
              new ScheduleBuilder().minutes(600, 4, -0.1,
                  null, "Friday", null, "UT2");
            });
    Assertions.assertEquals(
        exn.getMessage(),
        "The probability associated with the output " + "High intensity" + " was negative.");
  }

}
