
package com.cesanta.cloud;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import com.cesanta.cloud.AccountService;

import com.cesanta.clubby.lib.Clubby;
import com.cesanta.clubby.lib.CmdAdapter;

public class AccountTest extends CommonTest {
    private Clubby clubby;
    private AccountService account = null;
    private static final String descr = "Created by Java unit tests";

    private List<String> idsToDelete = null;

    @Before
    public void setUp() throws IOException
    {
        clubby = createClubby();
        account = AccountService.createInstance(clubby);
    }

    @After
    public void tearDown()
    {
        destroyClubby(clubby);
        clubby = null;
        account = null;
    }

    @Test
    public void tokensTest() {

        // Create account token
        setOk(false);
        account.createToken(
                new AccountService.CreateTokenArgs()
                    .description(descr),
                new CmdAdapter<String>() {
                    @Override
                    public void onResponse(String response) {
                        setOk(true);
                        notifyTest();
                    }

                    @Override
                    public void onError(int status, String status_msg) {
                        System.out.println("Error: Status: " + status + ", msg: " + status_msg);
                        notifyTest();
                    }
                }
                );
        waitForTest();
        if (!isOk()) {
            fail("AccountService.CreateToken failed");
        }

        // Collect IDs of all tokens with the test description
        // (there might be more than once due to some failed tests)
        setOk(false, "AccountService.listTokens failed");
        account.listTokens(
                new AccountService.ListTokensArgs(),
                new CmdAdapter<AccountService.ListTokensResponse>() {
                    @Override
                    public void onResponse(AccountService.ListTokensResponse response) {

                        List<String> idsToDelete = new ArrayList<String>();

                        for (AccountService.ListTokensResponseItem item : response) {
                            if (descr.equals(item.description)) {
                                idsToDelete.add(item.id);
                            }
                        }

                        if (idsToDelete.size() > 0) {
                            setOk(true);
                            setIdsToDelete(idsToDelete);
                        } else {
                            setOk(false, "No account token is added");
                        }
                        notifyTest();
                    }

                    @Override
                    public void onError(int status, String status_msg) {
                        System.out.println("Error: Status: " + status + ", msg: " + status_msg);
                        notifyTest();
                    }
                }
                );

        waitForTest();
        if (!isOk()) {
            fail(errorMsg());
        }

        // Delete tokens with collected IDs
        for (String id : idsToDelete) {
            setOk(false);
            account.revokeToken(
                    new AccountService.RevokeTokenArgs().id(id),
                    new CmdAdapter<AccountService.RevokeTokenResponse>() {
                        @Override
                        public void onResponse(AccountService.RevokeTokenResponse response) {
                            setOk(true);
                            notifyTest();
                        }

                        @Override
                        public void onError(int status, String status_msg) {
                            System.out.println("Error: Status: " + status + ", msg: " + status_msg);
                            notifyTest();
                        }
                    }
            );

            waitForTest();
            if (!isOk()) {
                fail(errorMsg());
            }

        }
    }

    private void setIdsToDelete(List<String> idsToDelete) {
        this.idsToDelete = idsToDelete;
    }
}
