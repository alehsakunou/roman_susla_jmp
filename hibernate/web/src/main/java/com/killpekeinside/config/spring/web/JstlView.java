package com.killpekeinside.config.spring.web;

import com.killpekeinside.exceptions.ConfigurationException;
import com.killpekeinside.util.Data;
import com.killpekeinside.util.StringConstants;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.InternalResourceView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by Raman_Susla1 on 10/2/2015.
 */
@Component
public class JstlView extends InternalResourceView
{
    private static final String EMPTY_VALUES_FOR_JSTL_VIEW = "Empty values for JstlView";

    public static String viewDirectory;
    public static String template;
    public static String templateVariable;
    public static String viewContentType;

    private void checkVariables()
    {
        if (Data.isEmpty(viewDirectory) || Data.isEmpty(template) || Data.isEmpty(templateVariable) || Data.isEmpty(viewContentType))
        {
            throw new ConfigurationException(EMPTY_VALUES_FOR_JSTL_VIEW);
        }
    }

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response)
            throws Exception
    {
        checkVariables();
        exposeModelAsRequestAttributes(model,request);
        StringBuilder builder = new StringBuilder();
        builder.append(viewDirectory);
        builder.append(StringConstants.RIGHT_SLASH);
        builder.append(template);
        String dispatcherPath = prepareForRendering(request, response);
        response.setContentType(viewContentType);
        request.setAttribute(templateVariable,
                dispatcherPath.substring(dispatcherPath.lastIndexOf(StringConstants.RIGHT_SLASH) + 1));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(builder.toString());
        requestDispatcher.include(request, response);

    }

    @Override
    protected boolean isUrlRequired()
    {
        return false;
    }
}

