package dev.qwett.portlet;

import dev.qwett.model.Person;
import dev.qwett.services.PersonService;

import javax.portlet.*;
import java.io.IOException;
import java.util.List;

public class HelloWorldPortlet extends GenericPortlet {

    private static int renderCount = 0;
    private static int actionCount = 0;
    public List<Person> personList;
    private final PersonService personService = new PersonService();

    public void render(RenderRequest request, RenderResponse response)
            throws PortletException, IOException {
        personList = personService.findAll();
        request.setAttribute("personList", personList);
        request.setAttribute("actionURL", response.createActionURL());
        PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher("/person.jsp");
        dispatcher.include(request, response);
        renderCount++;
        response.getWriter().print(
                "<p>execute render " + renderCount + "</p>"
                        + "<p>execute action " + actionCount + "</p>"
        );
    }

    public void processAction(ActionRequest request,
                              ActionResponse response) throws PortletException,
            IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        Person person = new Person(firstName, lastName);
        personService.add(person);
        actionCount++;
    }

}
