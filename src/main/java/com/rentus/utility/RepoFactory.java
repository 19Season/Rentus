package com.rentus.utility;

import com.rentus.repository.ToolRepository;
import com.rentus.repository.ToolRepositoryManager;

public class RepoFactory {


    public static ToolRepository getToolRepo()
        {
            return new ToolRepositoryManager();
        }
  /*  public static ClientRepository getClientRepo()
        {
         return new ClientRepositoryManager();
         }*/
    }

