package io.pivotal.pal.tracker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private Map<Long, TimeEntry> newTimeEntries = new HashMap<Long, TimeEntry>();

    private long id = 1L;

    public TimeEntry create(TimeEntry timeEntry) {
        TimeEntry createdTimeEntry = new TimeEntry(id++, timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours());
        newTimeEntries.put(createdTimeEntry.getId(), createdTimeEntry);
        return createdTimeEntry;
    }


    public TimeEntry find(long id) {
        return newTimeEntries.get(id);
    }

    public List<TimeEntry> list() {

        return newTimeEntries.values().stream().collect(Collectors.toList());
    }

    public TimeEntry update(long id, TimeEntry timeEntry) {
        if (newTimeEntries.get(id) != null) {
            TimeEntry createdTimeEntry = new TimeEntry(id, timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours());
            newTimeEntries.put(id, createdTimeEntry);
            return createdTimeEntry;
        }
        return null;
    }

    public void delete(long id) {
        newTimeEntries.remove(id);
    }
}
