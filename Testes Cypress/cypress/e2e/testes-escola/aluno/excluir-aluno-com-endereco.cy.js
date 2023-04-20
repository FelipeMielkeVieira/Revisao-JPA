describe("Excluir Aluno Com Endereço", () => {
    it("Excluir Aluno pelo seu ID junto com seu Endereço", () => {
        cy.request("DELETE", "http://localhost:8085/aluno/1").as("ExcluirAluno");
        cy.get("@ExcluirAluno").then(response => {
            expect(response.body).to.eq("Aluno deletado com sucesso!")
        })
    })
})