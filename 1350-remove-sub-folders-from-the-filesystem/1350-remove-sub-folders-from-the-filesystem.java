class Solution {
  class Node {
    Map<String, Node> next = new HashMap<>();
    boolean isEnd;
  }
  Node root = new Node();

  public List<String> removeSubfolders(String[] folder) {
    for (var path : folder) {
      var p = root;

      for (var dir : path.split("/")) {
        if (dir.equals("")) continue;

        if (!p.next.containsKey(dir))
          p.next.put(dir, new Node());

        p = p.next.get(dir);
      }
      p.isEnd = true;
    }
    var res = new ArrayList<String>();

    for (var path : folder) {
      var p = root;
      var isValid = true;

      for (var dir : path.split("/")) {
        if (dir.equals("")) continue;
        if (p.isEnd) {
          isValid = false;
          break;
        }
        p = p.next.get(dir);
      }
      if (isValid) res.add(path);
    }
    return res;
  }
}