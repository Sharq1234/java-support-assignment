public class Task2Analysis {

    /*
     * Question 1:
     * ConcurrentModificationException occurs when a collection
     * is modified while it is being iterated using an Iterator
     * or enhanced for-loop.
     */

    /*
     * Question 2:
     * Most likely code pattern:
     *
     * for (Transaction t : transactions) {
     *     transactions.remove(t);
     * }
     */

    /*
     * Question 3:
     * Minimal safe fix:
     *
     * Iterator<Transaction> it = transactions.iterator();
     *
     * while (it.hasNext()) {
     *     Transaction t = it.next();
     *
     *     if (condition) {
     *         it.remove();
     *     }
     * }
     */
}