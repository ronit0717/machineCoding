package com.rccode.model;

import java.util.LinkedList;
import java.util.List;

public class FlipKar {
    private List<Branch> branches;

    public FlipKar() {
        this.branches = new LinkedList<>();
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public void addBranch(Branch branch) {
        this.branches.add(branch);
    }
}
