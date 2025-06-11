public class TaskAdapter extends BaseAdapter {
    Context context;
    List<Task> tasks;

    public TaskAdapter(Context context, List<Task> tasks) {
        this.context = context;
        this.tasks = tasks;
    }

    @Override
    public int getCount() {
        return tasks.size();
    }

    @Override
    public Object getItem(int i) {
        return tasks.get(i);
    }

    @Override
    public long getItemId(int i) {
        return tasks.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        if (view == null)
            view = LayoutInflater.from(context).inflate(R.layout.list_item_task, parent, false);

        TextView title = view.findViewById(R.id.taskTitle);
        TextView deadline = view.findViewById(R.id.taskDeadline);
        Task t = tasks.get(i);

        title.setText(t.getTitle());
        deadline.setText("Due: " + t.getDeadline());

        return view;
    }
}
