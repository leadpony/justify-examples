package org.leadpony.justify.examples.problemhandler;

import java.io.PrintStream;
import java.util.List;

import javax.json.stream.JsonLocation;

import org.leadpony.justify.api.Problem;
import org.leadpony.justify.api.ProblemHandler;

/**
 * A custom problem handler which will format the found problems in a HTML table.
 *
 * For the sake of simplicity, this handler ignores the branches of the problem
 * even if there were multiple solutions for the problem.
 *
 * @see ProblemHandler
 */
public class MyProblemHandler implements ProblemHandler {

    private final PrintStream out;

    public MyProblemHandler() {
        this.out = System.out;
        // Outputs opening elements.
        out.println("<table>");
        out.println("<thead>");
        out.print("<tr>");
        out.print("<th>Line No.</th>");
        out.print("<th>Column No.</th>");
        out.print("<th>Message</th>");
        out.print("<th>Assertion Keyword</th>");
        out.print("</tr>");
        out.println();
        out.println("</thead>");
        out.println("<tbody>");
    }

    public void flush() {
        // Outputs closing elements.
        out.println("</tbody>");
        out.println("</table>");
    }

    /**
     * Handles the found problems.
     * We will output a row of the table for each problem.
     *
     * @param problems the found problems.
     */
    @Override
    public void handleProblems(List<Problem> problems) {
        for (Problem problem : problems) {
            JsonLocation loc = problem.getLocation();
            out.print("<tr>");
            out.print("<td>");
            out.print(loc.getLineNumber());
            out.print("</td>");
            out.print("<td>");
            out.print(loc.getColumnNumber());
            out.print("</td>");
            out.print("<td>");
            out.print(problem.getMessage());
            out.print("</td>");
            out.print("<td>");
            out.print(problem.getKeyword());
            out.print("</td>");
            out.print("</tr>");
            out.println();
        }
    }
}
